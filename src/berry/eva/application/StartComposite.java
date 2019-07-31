package berry.eva.application;

import org.eclipse.swt.SWT;
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
	Label label_start;
	Button button_start;
	Text text_root;
	
	
	public StartComposite(MainApplication mainApp ,Composite parent, int style) {
		super(parent, style);
		this.mainApp = mainApp;
		this.setLayout(new RowLayout());
		
		
		label_start = new Label(this, SWT.NONE);
		label_start.setText("Target : ");
		
		text_root = new Text(this, SWT.BORDER | SWT.SINGLE);
		text_root.setLayoutData(new RowData(200, SWT.DEFAULT) );
		text_root.setText("http://127.0.0.1:8188/");
		
		button_start = new Button(this, SWT.NONE);
		button_start.setText("START");
		button_start.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				System.out.println(text_root.getText());
				SearchEngine.getInstance().setUp("http://127.0.0.1:8188/dvwa/setup.php").searchingStart();
				
				SiteNodeManager.getInstance().setRootSiteContents(StartComposite.this.mainApp.getTreeViewer(), text_root.getText());
				
				
			}
		});
	}
}
