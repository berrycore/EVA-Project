package berry.eva.application;

import java.io.InputStream;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

public class SplashWindow {

	private int splashPos = 0;
	private final int SPLASH_MAX = 20;
	
	public SplashWindow(Display display) {
		final Image image = new Image(display, "images/boot_logo.png");
		final Shell splash = new Shell(SWT.ON_TOP);
		final ProgressBar bar = new ProgressBar(splash, SWT.NONE);
		bar.setMaximum(SPLASH_MAX);
		
		Label label = new Label(splash, SWT.NONE);
		label.setImage(image);
		label.setVisible(true);
		
		FormLayout layout= new FormLayout();
		splash.setLayout(layout);
		
		FormData labelData = new FormData();
		labelData.right = new FormAttachment(100, 0);
		labelData.left = new FormAttachment(100, 0);
		label.setLayoutData(labelData);
		
		
		FormData progressData = new FormData();
		progressData.left = new FormAttachment(0, -5);
		progressData.right = new FormAttachment(100, 0);
		progressData.bottom = new FormAttachment(100, 0);
		bar.setLayoutData(progressData);
		splash.pack();
		
		Rectangle splashRect = splash.getBounds();
		Rectangle displayRect = display.getBounds();
		int x = ( displayRect.width - splashRect.width ) / 2;
		int y = ( displayRect.height - splashRect.height ) / 2;
		splash.setLocation(x, y);
		splash.open();
		
		display.asyncExec(new Runnable() {
			
			@Override
			public void run() {
				for( splashPos = 0; splashPos < SPLASH_MAX; splashPos++) {
					try {
						Thread.sleep(100);
					}catch(InterruptedException e) {
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
		
		while(splashPos != SPLASH_MAX) {
			if( ! display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
