package berry.eva.core;

import java.io.IOException;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public final class Analyzer {

	private String HostName = "192.168.0.8";
	private HashSet<String> uniqueURL;

	public Analyzer() {
		uniqueURL = new HashSet<String>();
	}

	public void get_links_aTag(String url) {
		try {
			Document doc = Jsoup.connect(url).userAgent("EVA-Project").get();
			Elements links = doc.select("a");

			if (links.isEmpty()) {
				return;
			}

			links.stream().map((link) -> link.attr("abs:href")).forEachOrdered((this_url) -> {
				if (!uniqueURL.contains(this_url)) {

					if (this_url.contains(HostName)) {
						boolean add = uniqueURL.add(this_url);
						if (add) {
							get_links_aTag(this_url);
							System.out.println(this_url);
						}
					}
				}

			});

		} catch (IOException ex) {

		}
	}
}
