package berry.eva.core;

import java.util.Iterator;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public final class Analyzer {

	private static Analyzer instance = new Analyzer();
	
	public static Analyzer getInstance() {
		return instance;
	}

	private Analyzer() {

	}

	public void analyze(Document doc) {
		Elements links = doc.select("a");
		Iterator<Element> iter = links.iterator();
		while(iter.hasNext()) {
			Element link = iter.next();
			String url = link.attr("abs:href");
			if(Validator.isinScope(url)) {
	
			}
		}
	}
}
