package berry.eva.application;

import org.eclipse.swt.widgets.Display;

public class ApplicationLauncher {

	public static void main(String[] args) {
		MainApplication awindow = new MainApplication();
		awindow.setBlockOnOpen(true);
		awindow.open();
		Display.getCurrent().dispose();
	}
}
