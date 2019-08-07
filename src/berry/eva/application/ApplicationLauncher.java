package berry.eva.application;

import org.eclipse.swt.widgets.Display;

import berry.eva.core.Status;
import berry.eva.core.Status.Scanning;
import berry.eva.core.Status.Searching;

public final class ApplicationLauncher {
	
	

	public static void main(String[] args) {
		
		
		
		
		Display display = new Display();
		SplashWindow splashWindow = new SplashWindow(display);
		
		while((Display.getCurrent().isDisposed())) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
					
			
		MainApplication awindow = MainApplication.getInstance();
		awindow.setBlockOnOpen(true);
		
		awindow.open();
		Display.getCurrent().dispose();
		
		Status.setStatus(Searching.OFF);
		Status.setStatus(Scanning.OFF);
	
	}
}
