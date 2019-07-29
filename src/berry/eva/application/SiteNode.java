package berry.eva.application;

import java.util.ArrayList;
import java.util.List;

public class SiteNode {
	
	private SiteNode parent;
	private List<SiteNode> child = new ArrayList<SiteNode>();
	private String kind = "";
	private String contents = "";
	
	
	public SiteNode(SiteNode parent, String kind, String contents) {
		this.parent = parent;
		this.kind = kind;
		this.contents = contents;
	}
	
	public String getKind() {
		return this.kind;
	}
	
	public String getContents() {
		return this.contents;
	}
	
	public SiteNode getParent() {
		return this.parent;
	}
	
	public List<SiteNode> getChild(){
		return this.child;
	}
}
