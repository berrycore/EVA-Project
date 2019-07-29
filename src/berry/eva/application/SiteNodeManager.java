package berry.eva.application;

import java.net.URISyntaxException;

import org.apache.http.client.utils.URIBuilder;
import org.eclipse.jface.viewers.TreeViewer;

public class SiteNodeManager {

	private static SiteNodeManager instance = new SiteNodeManager();
	private SiteNodeManager() { }
	public static SiteNodeManager getInstance() {
		return instance;
	}
	
	private SiteNode root = null;
	
	public SiteNode createDefaultTree() {
		SiteNode dummy = new SiteNode(null, R.KIND.SITE, "dummy");
		root = new SiteNode(dummy, R.KIND.SITE, "site");
		dummy.getChild().add(root);
		return dummy;
	}
	
	public void setRootSiteContents(TreeViewer treeViewer, String contents) {
		root.setContents(contents);
		treeViewer.refresh();
	}
	
	public void addSiteNode(TreeViewer treeViewer, String url) {
		//TODO : root -> http://127.0.0.1/
        //       node1   http://127.0.0.1/dvwa/setup.php
		
		try {
			URIBuilder 	uriBuilder = new URIBuilder("http://127.0.0.1/dvwa/setup.php");
			System.out.println(uriBuilder.getHost());
			System.out.println(uriBuilder.getFragment());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public SiteNode createTestTree() {
		SiteNode none = new SiteNode(null, R.KIND.SITE, "none");
		SiteNode root = new SiteNode(none, R.KIND.SITE, "site");
		SiteNode dir1 = new SiteNode(root, R.KIND.DIR, "directory1");
		SiteNode dir2 = new SiteNode(root, R.KIND.DIR, "directory2");
		SiteNode file1 = new SiteNode(dir1, R.KIND.FILE, "file1");
		SiteNode file2 = new SiteNode(dir1, R.KIND.FILE, "file2");
		SiteNode file3 = new SiteNode(dir2, R.KIND.FILE, "file2");
		
		none.getChild().add(root);
		
		root.getChild().add(dir1);
		root.getChild().add(dir2);
		
		dir1.getChild().add(file1);
		dir1.getChild().add(file2);
		dir2.getChild().add(file3);
		
		return none;
	}
}
