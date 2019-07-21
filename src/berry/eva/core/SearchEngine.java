package berry.eva.core;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import berry.eva.core.Status.Searching;

public class SearchEngine implements Runnable {

	private SearchEngine() {
	};

	private static SearchEngine instance = new SearchEngine();
	private URLQueue urlQueue = URLQueue.getInstance();
	private String domain;
	private String root;

	public static SearchEngine getInstance() {
		return instance;
	}

	public SearchEngine setUp(String root) {
		this.root = root;
		this.domain = extractDomain(root);
		return this;
	}
	
	public String getCurrentDomain() {
		return domain;
	}
	
	private String extractDomain(String url) {
		URL netUrl = null;
		try {
			netUrl = new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	    return netUrl.getHost();
	}
	
	public void offer(String url) {
		urlQueue.offer(url);
	}

	public void searchingStart() {
		urlQueue.offer(root);
		Status.setStatus(Searching.ON);
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		while (Status.isSearching()) {
			if( urlQueue.isEmpty() == false) {
				String url = urlQueue.poll();
				try {
					Connection.Response response = Jsoup.connect(url)
							.timeout(1000)
							.header("User-Agent", "EVA-Project")
							.method(Connection.Method.GET)
							.execute();
					Document document = response.parse();

					Analyzer ana = Analyzer.getInstance();
					ana.analyze(document);
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
