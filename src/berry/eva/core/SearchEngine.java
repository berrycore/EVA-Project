package berry.eva.core;

import java.net.MalformedURLException;
import java.net.URL;

import berry.eva.application.MainApplication;
import berry.eva.core.Status.Searching;
import berry.eva.evaluation.Analyzer;

public class SearchEngine {

	// singleTon
	private SearchEngine() { };
	private static SearchEngine instance = new SearchEngine();
	public static SearchEngine getInstance() {
		return instance;
	}
	
	// member field
	private String domain;
	private String root;


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

	public void searchingStart() {
		Status.setStatus(Searching.ON);
		Thread crawler = new Thread(new Crawler( MainApplication.getInstance() ,root, domain));
		crawler.start();
		
	}
	
	public String getRoot() {
		return this.root;
	}
}
