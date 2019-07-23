package berry.eva.evaluation;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import berry.eva.core.Context;
import berry.eva.core.URLQueue;

public class PayloadInjector {

	private List<Context> list = new LinkedList<Context>();
	
	public void scanStart(URLQueue queue) {
		Iterator<String> iter = queue.iterator();
		while(iter.hasNext()) {
			String url = iter.next();
			try {
				
				Connection.Response response = Jsoup.connect(url)
												.userAgent("EVA-Project")
												.timeout(3000)
												.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\")
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
