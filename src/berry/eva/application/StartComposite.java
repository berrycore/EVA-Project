package berry.eva.application;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import berry.eva.core.SearchEngine;

public class StartComposite extends Composite {

	private MainApplication mainApp;
	private Label label_start;
	private Button button_start;
	private Text text_root;
	private Label label_warning;
	
	
	public StartComposite(MainApplication mainApp ,Composite parent, int style) {
		super(parent, style);
		this.mainApp = mainApp;
		this.setLayout(new FillLayout(SWT.VERTICAL));
		
		initComponents(this);
		initWarning(this);
		
	}
	
	private void initWarning(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		label_warning = new Label(container, SWT.BOLD);
		label_warning.setText(R.TEXT.WARNING);
		label_warning.setFont(new Font(getDisplay(), "Consolas", 12, SWT.NONE));
		
	}
	
	private void initComponents(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		//container.setLayout(new FillLayout(SWT.HORIZONTAL));
		container.setLayout(new RowLayout(SWT.HORIZONTAL));
		
		label_start = new Label(container, SWT.NONE);
		label_start.setText("Target : ");
		label_start.setFont(new Font(getDisplay(), "Consolas", 12, SWT.NONE));
		
		text_root = new Text(container, SWT.BORDER | SWT.SINGLE);
		text_root.setLayoutData(new RowData(400, SWT.DEFAULT) );
		text_root.setText("http://127.0.0.1:8188/");
		text_root.setFont(new Font(getDisplay(), "Consolas", 12, SWT.NONE));
		
		button_start = new Button(container, SWT.NONE);
		button_start.setText("START");
		button_start.setFont(new Font(getDisplay(), "Consolas", 12, SWT.NONE));
		button_start.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				
				SearchEngine.getInstance().setUp(text_root.getText()).searchingStart();
				
				SiteNodeManager.getInstance().setRootSiteContents(StartComposite.this.mainApp.getTreeViewer(), text_root.getText());
				
			}
		});
	}
}
