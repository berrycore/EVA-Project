package berry.eva.application;

import java.util.ArrayList;
import java.util.List;

public class SiteNode {
	
	private SiteNode parent;
	private List<SiteNode> child = new ArrayList<SiteNode>();
	private String kind = "";
	private String contents = "";
	
	public SiteNode() {
		
	}
	
	public SiteNode(String kind, String contents) {
		this.kind = kind;
		this.contents = contents;
	}
	
	public SiteNode(SiteNode parent, String kind, String contents) {
		this.parent = parent;
		this.kind = kind;
		this.contents = contents;
	}
	
	public void setParent(SiteNode parent) {
		this.parent = parent;
	}
	
	public void setKind(String kind) {
		this.kind = kind;
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
	
	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "SiteNode [parent=" + parent + ", child=" + child + ", kind=" + kind + ", contents=" + contents + "]";
	}
	
	
}
