package berry.eva.evaluation;

import java.net.URL;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import berry.eva.application.MainApplication;
import berry.eva.core.Context;
import berry.eva.core.ContextManager;
import berry.eva.core.Status;
import berry.eva.core.Status.Scanning;
import berry.eva.core.Status.Searching;
import berry.eva.evaluation.scan.ScanMethodPUT;
import berry.eva.evaluation.scan.ScanWEBINF;
import berry.eva.core.URLQueue;
import berry.eva.policy.PolicyManager;

public final class Analyzer implements Runnable {

	// singleTon
	private Analyzer() {
	}

	private static Analyzer instance = new Analyzer();

	public static Analyzer getInstance() {
		return instance;
	}

	public void setPolicy() {
		// TODO
	}

	public void startScan(String url) {
		MainApplication mainApp = MainApplication.getInstance();		
		List<Vulnerable> v_list = PolicyManager.getInstance().getPolicy().getList();
		
		for (Vulnerable vul : v_list) {
			Context context = vul.execute(url);

			mainApp.getShell().getDisplay().asyncExec(new Runnable() {

				@Override
				public void run() {
					Table scanTable = mainApp.getScanComposite().getTable();
					
					int itemsLength = scanTable.getItems().length + 1;
					TableItem item = new TableItem(scanTable, SWT.NONE);
					item.setText(0, String.valueOf(itemsLength));
					item.setText(1, context.getURL());
					item.setText(2, context.getMethod());
					item.setText(3, context.getReq_Timestamp());
					item.setText(4, context.getResp_Timestamp());
					item.setText(5, context.getResp_Code());
					item.setText(6, context.getResp_Reason());
					item.setText(7, context.getIsVulnerable() + "");
					item.setText(8, context.getCWE_ID());
					
					String req_body = context.getReq_Body() == null ? "" : context.getReq_Body();
					String resp_body = context.getResp_Body() == null ? "" : context.getResp_Body();
					
					item.setText(9, context.getReq_Header().toString());
					item.setText(10, req_body);
					item.setText(11, context.getResp_Headers().toString());
					item.setText(12, resp_body);
					
					ContextManager.getInstance().put(itemsLength, context);
					// 0 : id
					// 1 : url
					// 2 : method
					// 3 : req time
					// 4 : resp time
					// 5 : resp code
					// 6 : resp reason
					// 7 : isVulnerable?
					// 8 : cwe_id
				}
			});
		}
	}

	@Override
	public void run() {

		
		
		Status.TASK_COUNT = URLQueue.getInstance().getSize() * PolicyManager.getInstance().getPolicy().getList().size();
		System.out.println(Status.TASK_COUNT);
		
		
		// while(Status.isSearching()) {
		while ((URLQueue.getInstance().isEmpty() == false) && (Status.isScanning())) {
			System.out.println("Analyzer is waiting...");

			String url = URLQueue.getInstance().poll();
			if (url != null) {
				startScan(url);
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Status.setStatus(Scanning.OFF);
	}
}
