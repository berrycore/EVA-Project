package berry.eva.evaluation;

import java.util.LinkedList;
import java.util.List;

import berry.eva.core.URLQueue;
import berry.eva.evaluation.scan.HTTPMethodScan;

public final class Analyzer implements Runnable{
	
	// singleTon
	private Analyzer() { }
	private static Analyzer instance = new Analyzer();
	public static Analyzer getInstance() {
		return instance;
	}

	
	
	public void setPolicy() {
		//TODO
	}
	
	public void startScan(String url) {
		
		List<Vulnerable> v_list = new LinkedList<Vulnerable>();
		v_list.add(new HTTPMethodScan());
		
		for(Vulnerable vul : v_list) {
			Result result = vul.execute(url);
			System.out.println(result.toString());
		}
		
	}

	@Override
	public void run() {

		while(true) {
			
			System.out.println("Analyzer is waiting...");
			//System.out.println("URLQueue.getInstance().poll() -> " + URLQueue.getInstance().poll());
			String url = URLQueue.getInstance().poll();
			if(url != null) {
				startScan(url);				
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
