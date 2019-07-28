package berry.eva.policy;

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
	
}
