package berry.eva.application;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import berry.eva.evaluation.Analyzer;

public class ScanComposite extends Composite {
	
	private Table table;
	private ProgressBar progressBar;
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
		column_url.setWidth(400);
		
		TableColumn column_method = new TableColumn(table, SWT.CENTER);
		column_method.setText("Method");
		column_method.setWidth(60);
		
		TableColumn column_Req_Timestamp = new TableColumn(table, SWT.CENTER);
		column_Req_Timestamp.setText("ReqTime");
		column_Req_Timestamp.setWidth(70);
		
		TableColumn column_Resp_Timestamp = new TableColumn(table, SWT.CENTER);
		column_Resp_Timestamp.setText("RespTime");
		column_Resp_Timestamp.setWidth(70);
		
		TableColumn column_Resp_code = new TableColumn(table, SWT.CENTER);
		column_Resp_code.setText("Resp_Code");
		column_Resp_code.setWidth(70);
		
		TableColumn column_Resp_reason = new TableColumn(table, SWT.CENTER);
		column_Resp_reason.setText("reason");
		column_Resp_reason.setWidth(80);
		
		TableColumn column_isVulnerable = new TableColumn(table, SWT.CENTER);
		column_isVulnerable.setText("isVulnerable");
		column_isVulnerable.setWidth(50);

	}

	private void initProgressBar() {
		Composite innerComposite = new Composite(this, SWT.NONE);
		//innerComposite.setLayout(new GridLayout(1, true));
		innerComposite.setLayout(new RowLayout(SWT.HORIZONTAL));
		progressBar = new ProgressBar(innerComposite, SWT.NONE);
		
		button_selectPolicy = new Button(innerComposite, SWT.CENTER);
		button_selectPolicy.setText("Policy : Default");
		
		button_startScan = new Button(innerComposite, SWT.CENTER);
		button_startScan.setText("Scan Start");
		button_startScan.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				System.out.println("scan started !");
				Thread analyzer = new Thread(Analyzer.getInstance());
				analyzer.start();
			}
		});
	}
	
	public Table getTable() {
		return this.table;
	}
}
