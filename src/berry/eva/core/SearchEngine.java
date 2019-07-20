package berry.eva.core;

public class SearchEngine implements Runnable{
	
	private SearchEngine() {};
	private static SearchEngine instance = new SearchEngine();
	private URLQueue queue = URLQueue.getInstance();
	private Crawler cralwer = Crawler.getInstance();
	
	public static SearchEngine getInstance() {
		return instance;
	}

	@Override
	public void run() {
		while(queue.isEmpty() == false) {
			Context context = queue.peek();
			// TODO : cralwer.sendGet( context.)
		}
		
	}
	
//	public Context generate(Config config) {
//		Context context = new Context();
//		// TODO context.set
//				
//	}
	
}
