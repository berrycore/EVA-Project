package berry.eva.evaluation;

public class Result {

	private AttackClassification category;
	private String attackName;
	private String description;

	public Result(AttackClassification category, String attackName, String description) {
		this.category = category;
		this.attackName = attackName;
		this.description = description;
	}

	public AttackClassification getCategory() {
		return category;
	}

	public String getAttackName() {
		return attackName;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attackName == null) ? 0 : attackName.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
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
		Result other = (Result) obj;
		if (attackName == null) {
			if (other.attackName != null)
				return false;
		} else if (!attackName.equals(other.attackName))
			return false;
		if (category != other.category)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}
}
