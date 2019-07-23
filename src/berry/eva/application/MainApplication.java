package berry.eva.application;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

public final class MainApplication extends ApplicationWindow {

	public MainApplication() {
		super(null);
	}

	@Override
	protected Control createContents(Composite parent) {
		Text text = new Text(parent, SWT.CENTER);
		text.setText("Hello JFace");
		parent.pack();
		return parent;
	}

}
