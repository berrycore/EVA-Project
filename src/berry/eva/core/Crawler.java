package berry.eva.core;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TreeItem;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import berry.eva.application.MainApplication;
import berry.eva.application.SiteNode;
import berry.eva.application.SiteNodeManager;

public class Crawler implements Runnable {

	// member field
	private MainApplication mainApp;
	private String domain;
	private String root;

	public Crawler(MainApplication mainApp, String root, String domain) {
		this.mainApp = mainApp;
		this.root = root;
		this.domain = domain;
	}

	private HashSet<String> links = new HashSet<String>();

	private void getPageLinks(String URL) {
		// 4. Check if you have already crawled the URLs
		// (we are intentionally not checking for duplicate content in this example)
		if (URL.contains(domain) && !links.contains(URL)) {
			try {
				// 4. (i) If not add it to the index

				if (links.add(URL)) {
					System.out.println(URL);
				}

				// 2. Fetch the HTML code
				Document document = Jsoup.connect(URL).get();
				// 3. Parse the HTML to extract links to other URLs
				Elements linksOnPage = document.select("a[href]");

				// 5. For each extracted URL... go back to Step 4.
				for (Element page : linksOnPage) {
					String link = page.attr("abs:href");
					getPageLinks(link);
				}

			} catch (IOException e) {
				System.err.println("For '" + URL + "': " + e.getMessage());
				if (e.getMessage().contains(
						"Unhandled content type. Must be text/*, application/xml, or application/xhtml+xml")) {
					links.add(URL);
				}

			}
		}
	}

	@Override
	public void run() {
		
		mainApp.getSpiderComposite().progressBarStart();
		
		getPageLinks(root);
		for (String url : links) {
			URLQueue.getInstance().offer(url);

			mainApp.getShell().getDisplay().asyncExec(new Runnable() {
				public void run() {
					if (mainApp.getSpiderComposite().getTable().isDisposed())
						return;
					TableItem item = new TableItem(mainApp.getSpiderComposite().getTable(), SWT.NONE);
					item.setText(url);
					SiteNodeManager.getInstance().insertNode(mainApp.getTreeViewer(), url);	
				}
			});
		}
		mainApp.getSpiderComposite().progressBarStop();
		// TODO : update TreeViewer
		
		
	}
}
