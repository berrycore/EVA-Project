package berry.eva.application;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
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

import berry.eva.core.Config;

public class BasicConfigDialog extends TitleAreaDialog {

	private Label label_userAgent;
	private Label label_pragma;
	private Label label_cacheControl;
	private Label label_cookie;
	private Text text_userAgent;
	private Text text_pragma;
	private Text text_cacheControl;
	private Text text_cookie;
	private Config config;
	
	
	public BasicConfigDialog(Shell parentShell) {
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
		group_head.setFont(new Font(getShell().getDisplay(), "Consolas", 12, SWT.NONE));
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
		label_userAgent.setText("User-Agent      ");
		label_userAgent.setFont(new Font(getShell().getDisplay(), "Consolas", 12, SWT.NONE));
		text_userAgent = new Text(composite_useragent, SWT.BORDER);
		text_userAgent.setLayoutData(new RowData(350, SWT.DEFAULT));
		text_userAgent.setText(R.HTTP_HEAD_CONFIG.userAgent);
		text_userAgent.setFont(new Font(getShell().getDisplay(), "Consolas", 12, SWT.NONE));
				
		label_pragma = new Label(composite_pragma, SWT.NONE);
		label_pragma.setText("Pragma          ");
		label_pragma.setFont(new Font(getShell().getDisplay(), "Consolas", 12, SWT.NONE));
		text_pragma = new Text(composite_pragma, SWT.BORDER);
		text_pragma.setLayoutData(new RowData(350, SWT.DEFAULT));
		text_pragma.setText(R.HTTP_HEAD_CONFIG.pragma);
		text_pragma.setFont(new Font(getShell().getDisplay(), "Consolas", 12, SWT.NONE));
		
		label_cacheControl = new Label(composite_cacheControl, SWT.NONE);
		label_cacheControl.setText("Cache-Control   ");
		label_cacheControl.setFont(new Font(getShell().getDisplay(), "Consolas", 12, SWT.NONE));
		text_cacheControl = new Text(composite_cacheControl, SWT.BORDER);
		text_cacheControl.setLayoutData(new RowData(350, SWT.DEFAULT));
		text_cacheControl.setText(R.HTTP_HEAD_CONFIG.cacheControl);
		text_cacheControl.setFont(new Font(getShell().getDisplay(), "Consolas", 12, SWT.NONE));
		
		label_cookie = new Label(composite_cookie, SWT.NONE);
		label_cookie.setText("Cookie          ");
		label_cookie.setFont(new Font(getShell().getDisplay(), "Consolas", 12, SWT.NONE));
		text_cookie = new Text(composite_cookie, SWT.BORDER);
		text_cookie.setLayoutData(new RowData(350, SWT.DEFAULT));
		text_cookie.setText(R.HTTP_HEAD_CONFIG.cookie);
		text_cookie.setFont(new Font(getShell().getDisplay(), "Consolas", 12, SWT.NONE));
	}
	
	@Override
	protected boolean isResizable() {
		return false;
	}
}
