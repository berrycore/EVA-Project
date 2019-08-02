package berry.eva.application;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class HelpDialog extends TitleAreaDialog{

	public HelpDialog(Shell parentShell) {
		super(parentShell);

	}

	@Override
	public void create() {
		super.create();
		
		setTitle("Help");
		setMessage("Contact", IMessageProvider.INFORMATION);
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);

		showMessages(container, getShell().getDisplay());
		
		return area;
	}

	private void showMessages(Composite parent, Display display) {
		Image logo = new Image(display, "images/logo.png");
		Label label_logo = new Label(parent, SWT.NONE);
		label_logo.setImage(logo);
		
		Label label_msg = new Label(parent, SWT.NONE); 
		label_msg.setText( R.EVA_PROJECT +"\n\n"+ R.TEXT.HElP_VERSION + "\n" + R.TEXT.HELP_CONTACT + "\n" + R.TEXT.HELP_EMAIL);
		label_msg.pack();
	}
	
	@Override
	protected boolean isResizable() {
		return false;
	}

}
