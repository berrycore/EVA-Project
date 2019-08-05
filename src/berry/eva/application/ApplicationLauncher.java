package berry.eva.application;

import org.eclipse.swt.widgets.Display;

import berry.eva.core.Status;
import berry.eva.core.Status.Scanning;
import berry.eva.core.Status.Searching;

public final class ApplicationLauncher {

	public static void main(String[] args) {
		
		//TODO : splash screeen
		
		MainApplication awindow = new MainApplication();
		awindow.setBlockOnOpen(true);
		awindow.open();
		Display.getCurrent().dispose();
		
		Status.setStatus(Searching.OFF);
		Status.setStatus(Scanning.OFF);
	
	}
}
