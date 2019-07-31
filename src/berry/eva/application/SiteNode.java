package berry.eva.application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SiteNode {
	
	private SiteNode parent;
	private List<SiteNode> child = new ArrayList<SiteNode>();
	//private Set<SiteNode> child = new HashSet<SiteNode>();
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((child == null) ? 0 : child.hashCode());
		result = prime * result + ((contents == null) ? 0 : contents.hashCode());
		result = prime * result + ((kind == null) ? 0 : kind.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SiteNode other = (SiteNode) obj;
		if (child == null) {
			if (other.child != null)
				return false;
		} else if (!child.equals(other.child))
			return false;
		if (contents == null) {
			if (other.contents != null)
				return false;
		} else if (!contents.equals(other.contents))
			return false;
		if (kind == null) {
			if (other.kind != null)
				return false;
		} else if (!kind.equals(other.kind))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SiteNode [parent=" + parent + ", child=" + child + ", kind=" + kind + ", contents=" + contents + "]";
	}

	
	
}
