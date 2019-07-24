package berry.eva.evaluation;

public class Weakness {

	private Category category;
	private String cwe_id;
	private String attackName;
	private String description;
	
	public Weakness(Category category, String cwe_id, String attackName, String description) {
		this.category = category;
		this.cwe_id = cwe_id;
		this.attackName = attackName;
		this.description = description;
	}
}
