package berry.eva.core;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SearchEngine implements Runnable{
	
	private SearchEngine() {};
	private static SearchEngine instance = new SearchEngine();
	private URLQueue queue = URLQueue.getInstance();
	private Crawler cralwer = Crawler.getInstance();
	private Integer count = 1;
	private String root;
	
	public static SearchEngine getInstance() {
		return instance;
	}
	
	public boolean clear() {
		return queue.clearAll();
	}
	
	public SearchEngine setUp(String root) {
		this.root = root;
		return this;
	}
	
	public void searchingStart() {
		Context context = generate(root);
		queue.offer(context);	
		Thread thread = new Thread(this);
		thread.start();
	}
		
	private Context generate(String url) {
		Context context = new Context();
		context.setIndex(count++);
		context.setTime_request(getCurrentTime());
		context.setUrl(url);
		context.setScanned(false);
		return context;
	}

	@Override
	public void run() {
		
		while(queue.isEmpty() == false) {
			
			Context context = queue.poll();
			String url = context.getUrl();
			System.out.println(url);
			
			try {
				Connection.Response response = null;
				response = Jsoup.connect(url).userAgent("EVA-Project").timeout(10000).execute();
				if( response != null ) {
					context.setScanned(true);
					String body = response.body();
					Document document = Jsoup.parse(body);
					Elements elements = document.select("a");
					for( Element e : elements ) {
						String link = e.attr("abs:href");
						System.out.println(link);
						queue.offer(generate(link + document.baseUri()));
					}
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	private String getCurrentTime() {
		long time = System.currentTimeMillis(); 
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		return dayTime.format(new Date(time));
	}
}
