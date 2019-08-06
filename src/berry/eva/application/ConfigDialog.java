package berry.eva.application;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.omg.PortableInterceptor.USER_EXCEPTION;

import berry.eva.core.Config;

public class ConfigDialog extends TitleAreaDialog {

	private Label label_userAgent;
	private Label label_pragma;
	private Label label_cacheControl;
	private Label label_cookie;
	private Text text_userAgent;
	private Text text_pragma;
	private Text text_cacheControl;
	private Text text_cookie;
	private Config config;
	
	
	public ConfigDialog(Shell parentShell) {
		super(parentShell);

	}
	
	public Config getConfig() {
		return this.config;
	}
	
	@Override
	protected void okPressed() {
		String userAgent = text_userAgent.getText();
		String pragma = text_pragma.getText();
		String cacheControl = text_cacheControl.getText();
		String cookie = text_cookie.getText();
		this.config = new Config(userAgent, pragma, cacheControl, cookie);
		super.okPressed();
	}

	@Override
	public void create() {
		super.create();
		
		setTitle("Config");
		
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);

		initComponents(container);
		
		return area;
	}
	
	private void initComponents(Composite container) {
		Group group_head = new Group(container, SWT.NONE);
		group_head.setText("HTTP Head");
		group_head.setLayout(new GridLayout(1, false));
		Composite composite_useragent = new Composite(group_head, SWT.NONE);
		composite_useragent.setLayout(new RowLayout(SWT.HORIZONTAL));
		Composite composite_pragma = new Composite(group_head, SWT.NONE);
		composite_pragma.setLayout(new RowLayout(SWT.HORIZONTAL));
		Composite composite_cacheControl = new Composite(group_head, SWT.NONE);
		composite_cacheControl.setLayout(new RowLayout(SWT.HORIZONTAL));
		Composite composite_cookie = new Composite(group_head, SWT.NONE);
		composite_cookie.setLayout(new RowLayout(SWT.HORIZONTAL));
		
		label_userAgent = new Label(composite_useragent, SWT.NONE);
		label_userAgent.setText("User-Agent        ");
		text_userAgent = new Text(composite_useragent, SWT.BORDER);
		text_userAgent.setLayoutData(new RowData(350, SWT.DEFAULT));
		text_userAgent.setText("Mozilla/5.0 (Windows NT 6.3; WOW64; rv:39.0) Gecko/20100101 Firefox/39.0");
				
		label_pragma = new Label(composite_pragma, SWT.NONE);
		label_pragma.setText("Pragma             ");
		text_pragma = new Text(composite_pragma, SWT.BORDER);
		text_pragma.setLayoutData(new RowData(350, SWT.DEFAULT));
		text_pragma.setText("no-cache");
		
		label_cacheControl = new Label(composite_cacheControl, SWT.NONE);
		label_cacheControl.setText("Cache-Control    ");
		text_cacheControl = new Text(composite_cacheControl, SWT.BORDER);
		text_cacheControl.setLayoutData(new RowData(350, SWT.DEFAULT));
		text_cacheControl.setText("no-cache");
		
		label_cookie = new Label(composite_cookie, SWT.NONE);
		label_cookie.setText("Cookie              ");
		text_cookie = new Text(composite_cookie, SWT.BORDER);
		text_cookie.setLayoutData(new RowData(350, SWT.DEFAULT));
		text_cookie.setText("");
	}
	
	@Override
	protected boolean isResizable() {
		return false;
	}
}
