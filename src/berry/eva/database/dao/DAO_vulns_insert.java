package berry.eva.database.dao;

public class DAO_vulns_insert {

	private String projectname;
	private String policyname;
	private String cwe_id;
	private Integer cwe_enable;

	public DAO_vulns_insert() {

	}

	
	
	public DAO_vulns_insert(String projectname, String policyname, String cwe_id, Integer cwe_enable) {
		super();
		this.projectname = projectname;
		this.policyname = policyname;
		this.cwe_id = cwe_id;
		this.cwe_enable = cwe_enable;
	}



	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getPolicyname() {
		return policyname;
	}

	public void setPolicyname(String policyname) {
		this.policyname = policyname;
	}

	public String getCwe_id() {
		return cwe_id;
	}

	public void setCwe_id(String cwe_id) {
		this.cwe_id = cwe_id;
	}

	public Integer getCwe_enable() {
		return cwe_enable;
	}

	public void setCwe_enable(Integer cwe_enable) {
		this.cwe_enable = cwe_enable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cwe_enable == null) ? 0 : cwe_enable.hashCode());
		result = prime * result + ((cwe_id == null) ? 0 : cwe_id.hashCode());
		result = prime * result + ((policyname == null) ? 0 : policyname.hashCode());
		result = prime * result + ((projectname == null) ? 0 : projectname.hashCode());
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
		DAO_vulns_insert other = (DAO_vulns_insert) obj;
		if (cwe_enable == null) {
			if (other.cwe_enable != null)
				return false;
		} else if (!cwe_enable.equals(other.cwe_enable))
			return false;
		if (cwe_id == null) {
			if (other.cwe_id != null)
				return false;
		} else if (!cwe_id.equals(other.cwe_id))
			return false;
		if (policyname == null) {
			if (other.policyname != null)
				return false;
		} else if (!policyname.equals(other.policyname))
			return false;
		if (projectname == null) {
			if (other.projectname != null)
				return false;
		} else if (!projectname.equals(other.projectname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DAO_vulns [projectname=" + projectname + ", policyname=" + policyname + ", cwe_id=" + cwe_id
				+ ", cwe_enable=" + cwe_enable + "]";
	}

	
}
