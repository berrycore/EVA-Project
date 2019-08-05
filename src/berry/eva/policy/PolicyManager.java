package berry.eva.policy;

import berry.eva.database.CrudManager;
import berry.eva.database.dao.DAO_policy;

public class PolicyManager {

	private Policy policy;
	private static PolicyManager instance = new PolicyManager();
	private PolicyManager() {
		setDefaultPolicy();
	}
	
	public static PolicyManager getInstance() {
		return instance;
	}
	
	public Policy getPolicy() {
		return this.policy;
	}
	
	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	 
	private void setDefaultPolicy() {
		this.policy = new DefaultPolicy("default");
	}
	
	public void addPolicy(Policy policy, String projectName) {
		CrudManager crud = new CrudManager();
		crud.insert_policy(new DAO_policy(policy.getName(), projectName));
		
	}
	
}
