package berry.eva.application;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class SplashWindow {

	private int splashPos = 0;
	private final int SPLASH_MAX = 30;

	public SplashWindow(Display display) {

		final Shell splash = new Shell(display, SWT.ON_TOP);
		final Image image = new Image(display, "images/boot_logo.png");
		final ProgressBar bar = new ProgressBar(splash, SWT.NONE);
		final Text text = new Text(splash, SWT.BOLD);
		text.setText("Loading..");
		bar.setMaximum(SPLASH_MAX);

		Label label = new Label(splash, SWT.NONE);
		label.setImage(image);
		label.setVisible(true);
		label.pack();
		bar.pack();
		text.pack();
		splash.pack();

		Rectangle splashRect = splash.getBounds();
		Rectangle displayRect = display.getBounds();
		int x = (displayRect.width - splashRect.width) / 2;
		int y = (displayRect.height - splashRect.height) / 2;

		splash.setLocation(x, y);

		bar.setSize(displayRect.width, 100);
		bar.setLocation(0, displayRect.height / 2);

		splash.open();

		display.asyncExec(new Runnable() {

			@Override
			public void run() {
				for (splashPos = 0; splashPos < SPLASH_MAX; splashPos++) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					bar.setSelection(splashPos);

				}
				// TODO : main window init();
				MainApplication awindow = new MainApplication();
				awindow.setBlockOnOpen(true);
				splash.close();
				image.dispose();
			}
		});

		while (splashPos != SPLASH_MAX) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
