package berry.eva.evaluation;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import berry.eva.application.MainApplication;
import berry.eva.core.Context;
import berry.eva.core.SearchEngine;
import berry.eva.core.Status;
import berry.eva.core.URLQueue;
import berry.eva.evaluation.scan.HTTPMethodScan;
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
		// dummy list
		List<Vulnerable> v_list = new LinkedList<Vulnerable>();
		v_list.add(new HTTPMethodScan());
		// dummy list
		
		
		

		int index = 1;
		for (Vulnerable vul : v_list) {
			Result result = vul.execute(url);
			System.out.println(result.toString());

			mainApp.getShell().getDisplay().asyncExec(new Runnable() {

				@Override
				public void run() {
					Table scanTable = mainApp.getScanComposite().getTable();
					TableItem item = new TableItem(scanTable, SWT.NONE);
					item.setText(0, Integer.toString(index));
					item.setText(1, url);
					//item.setText(2, method);
				}
			});

		}

	}

	@Override
	public void run() {

		// while(Status.isSearching()) {
		while ((URLQueue.getInstance().isEmpty() == false) && (Status.isSearching())) {
			System.out.println("Analyzer is waiting...");
			// System.out.println("URLQueue.getInstance().poll() -> " +
			// URLQueue.getInstance().poll());
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

	}
}
