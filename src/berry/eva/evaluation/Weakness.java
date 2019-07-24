package berry.eva.evaluation;

public class Weakness {

	private Category category;
	private String cwe_id;
	private String attackName;
	private String description;
	
	public Weakness() {}
	
	public Weakness(Category category, String cwe_id, String attackName, String description) {
		this.category = category;
		this.cwe_id = cwe_id;
		this.attackName = attackName;
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getCwe_id() {
		return cwe_id;
	}

	public void setCwe_id(String cwe_id) {
		this.cwe_id = cwe_id;
	}

	public String getAttackName() {
		return attackName;
	}

	public void setAttackName(String attackName) {
		this.attackName = attackName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attackName == null) ? 0 : attackName.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((cwe_id == null) ? 0 : cwe_id.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		Weakness other = (Weakness) obj;
		if (attackName == null) {
			if (other.attackName != null)
				return false;
		} else if (!attackName.equals(other.attackName))
			return false;
		if (category != other.category)
			return false;
		if (cwe_id == null) {
			if (other.cwe_id != null)
				return false;
		} else if (!cwe_id.equals(other.cwe_id))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Weakness [category=" + category + ", cwe_id=" + cwe_id + ", attackName=" + attackName + ", description="
				+ description + "]";
	}
}
