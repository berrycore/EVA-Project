package berry.eva.database.dao;

public class DAO_policy {

	private String projectname;
	private String createdtime;
	
	public DAO_policy() {
		
	}
	
	public DAO_policy(String projectname, String createdtime) {
		this.projectname = projectname;
		this.createdtime = createdtime;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getCreatedtime() {
		return createdtime;
	}

	public void setCreatedtime(String createdtime) {
		this.createdtime = createdtime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdtime == null) ? 0 : createdtime.hashCode());
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
		DAO_policy other = (DAO_policy) obj;
		if (createdtime == null) {
			if (other.createdtime != null)
				return false;
		} else if (!createdtime.equals(other.createdtime))
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
		return "DAO_policy [projectname=" + projectname + ", createdtime=" + createdtime + "]";
	}
	
	
	
}
