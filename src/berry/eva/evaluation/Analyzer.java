package berry.eva.evaluation;

import berry.eva.core.URLQueue;

public final class Analyzer implements Runnable{
	
	// singleTon
	private Analyzer() { }
	private static Analyzer instance = new Analyzer();
	public static Analyzer getInstance() {
		return instance;
	}


	@Override
	public void run() {

		while(true) {
			
			System.out.println("Analyzer is waiting...");
			System.out.println("URLQueue.getInstance().poll() -> " + URLQueue.getInstance().poll());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
