package berry.eva.policy;


public class DTO_vulns {

	private Integer use;
	private String cwe_id;
	
	public DTO_vulns() {
		
	}
	
	public DTO_vulns(Integer use, String cwe_id) {
		this.use = use;
		this.cwe_id = cwe_id;
	}

	public Integer getUse() {
		return use;
	}

	public void setUse(Integer use) {
		this.use = use;
	}

	public String getCwe_id() {
		return cwe_id;
	}

	public void setCwe_id(String cwe_id) {
		this.cwe_id = cwe_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cwe_id == null) ? 0 : cwe_id.hashCode());
		result = prime * result + ((use == null) ? 0 : use.hashCode());
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
		DTO_vulns other = (DTO_vulns) obj;
		if (cwe_id == null) {
			if (other.cwe_id != null)
				return false;
		} else if (!cwe_id.equals(other.cwe_id))
			return false;
		if (use == null) {
			if (other.use != null)
				return false;
		} else if (!use.equals(other.use))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DTO_Vulns [use=" + use + ", cwe_id=" + cwe_id + "]";
	}
	
	
	
	
}
