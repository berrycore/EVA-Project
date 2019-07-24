package berry.eva.evaluation;

public class Result {

	private boolean isVulnerable = false;
	private String CWE_ID = "NotFound";
	
	public Result() {
		this(false, "NotFound");
	}
	
	public Result(boolean isVulnerable, String CWE_ID) {
		this.isVulnerable = isVulnerable;
		this.CWE_ID = CWE_ID;
	}
	
	public Result setVulnerable(boolean isVulnerable) {
		this.isVulnerable = isVulnerable;
		return this;
	}
	
	public Result setCWE_ID(String CWE_ID) {
		this.CWE_ID = CWE_ID;
		return this;
	}
	
	public boolean isVulnerable() {
		return isVulnerable;
	}

	public String getCWE_ID() {
		return CWE_ID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CWE_ID == null) ? 0 : CWE_ID.hashCode());
		result = prime * result + (isVulnerable ? 1231 : 1237);
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
		Result other = (Result) obj;
		if (CWE_ID == null) {
			if (other.CWE_ID != null)
				return false;
		} else if (!CWE_ID.equals(other.CWE_ID))
			return false;
		if (isVulnerable != other.isVulnerable)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Result [isVulnerable=" + isVulnerable + ", CWE_ID=" + CWE_ID + "]";
	}

}
