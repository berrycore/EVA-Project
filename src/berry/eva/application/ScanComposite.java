package berry.eva.application;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import berry.eva.core.Context;
import berry.eva.core.ContextManager;
import berry.eva.core.Status;
import berry.eva.core.Status.Scanning;
import berry.eva.evaluation.Analyzer;
import berry.eva.util.TextConverter;

public class ScanComposite extends Composite {
	
	private Table table;
	private ProgressBar progressBar;
	private Thread thread;
	
	private Button button_selectPolicy;
	private Button button_startScan;

	public ScanComposite(Composite parent, int style) {
		super(parent, style);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		this.setLayout(gridLayout);

		initProgressBar();
		initTable();
	}

	private void initTable() {
		final ScrolledComposite composite = new ScrolledComposite(this, SWT.NONE);
		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		table = new Table(composite, SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		table.setHeaderVisible(true);

		composite.setContent(table);
		composite.setExpandHorizontal(true);
		composite.setExpandVertical(true);
		composite.setAlwaysShowScrollBars(true);
		//composite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		TableColumn column_id = new TableColumn(table, SWT.CENTER);
		column_id.setText("id");
		column_id.setWidth(40);
		
		TableColumn column_url = new TableColumn(table, SWT.LEFT );
		column_url.setText("URL");
		column_url.setWidth(450);
		
		TableColumn column_method = new TableColumn(table, SWT.CENTER);
		column_method.setText("Method");
		column_method.setWidth(60);
		
		TableColumn column_Req_Timestamp = new TableColumn(table, SWT.CENTER);
		column_Req_Timestamp.setText("ReqTime");
		column_Req_Timestamp.setWidth(145);
		
		TableColumn column_Resp_Timestamp = new TableColumn(table, SWT.CENTER);
		column_Resp_Timestamp.setText("RespTime");
		column_Resp_Timestamp.setWidth(145);
		
		TableColumn column_Resp_code = new TableColumn(table, SWT.CENTER);
		column_Resp_code.setText("Resp_Code");
		column_Resp_code.setWidth(70);
		
		TableColumn column_Resp_reason = new TableColumn(table, SWT.CENTER);
		column_Resp_reason.setText("reason");
		column_Resp_reason.setWidth(60);
		
		TableColumn column_isVulnerable = new TableColumn(table, SWT.CENTER);
		column_isVulnerable.setText("isVulnerable");
		column_isVulnerable.setWidth(50);
		
		TableColumn column_cwe_id = new TableColumn(table, SWT.CENTER);
		column_cwe_id.setText("CWE_ID");
		column_cwe_id.setWidth(80);

		
		table.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				
				
				Integer key = table.getSelectionIndex()+1;
				Context context = ContextManager.getInstance().get(key);
				
				MainApplication mainApp = MainApplication.getInstance();
				mainApp.getReqRespComposite().getText_request_header().setText(TextConverter.MapToString(context.getReq_Header()));
				mainApp.getReqRespComposite().getText_request_body().setText(context.getReq_Body());
				mainApp.getReqRespComposite().getText_response_header().setText(TextConverter.MapToString(context.getResp_Headers()));
				mainApp.getReqRespComposite().getText_response_body().setText(context.getResp_Body());
				
			}
		});
	}

	private void initProgressBar() {
		Composite innerComposite = new Composite(this, SWT.NONE);
		//innerComposite.setLayout(new GridLayout(1, true));
		innerComposite.setLayout(new RowLayout(SWT.HORIZONTAL));
		progressBar = new ProgressBar(innerComposite, SWT.SMOOTH);
		
		button_selectPolicy = new Button(innerComposite, SWT.CENTER);
		button_selectPolicy.setText("Policy : Default");
		
		button_startScan = new Button(innerComposite, SWT.CENTER);
		button_startScan.setText("Scan Start");
		button_startScan.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				System.out.println("scan started !");
				Status.setStatus(Scanning.ON);
				progressBarStart();
				Thread analyzer = new Thread(Analyzer.getInstance());
				analyzer.start();
			}
		});
	}
	
	public Table getTable() {
		return this.table;
	}
	
	public void progressBarStart() {
		thread = new ScanningOperation(getDisplay(), progressBar);
		thread.start();
	}
	
	public void progressBarStop() {
		Status.setStatus(Status.Scanning.OFF);
	}
}


class ScanningOperation extends Thread {
	private Display display;
	private ProgressBar progressBar;

	public ScanningOperation(Display display, ProgressBar progressBar) {
		this.display = display;
		this.progressBar = progressBar;
	}

	public void run() {

		while(Status.isScanning()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			display.asyncExec(new Runnable() {
				public void run() {
					if (progressBar.isDisposed())
						return;
					progressBar.setMaximum(Status.TASK_COUNT);
					progressBar.setSelection(progressBar.getSelection() + 1);
				}
			});
		}
	}
}