package berry.eva.policy;

import java.text.SimpleDateFormat;
import java.util.Date;

import berry.eva.database.CrudManager;
import berry.eva.database.dao.DAO_policy;
import berry.eva.database.dao.DAO_vulns;

public class PolicyManager {

	private Policy policy;
	private static PolicyManager instance = new PolicyManager();
	private PolicyManager() {

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


	public PolicyManager addPolicy(Policy policy) {
		this.policy = policy;
		return this;
	}
	
	public PolicyManager insertPolicyToDatabase() {
		CrudManager crud = new CrudManager();
		DAO_policy dao = new DAO_policy(this.policy.getProjectName(), this.policy.getPolicyName(), getCurrentTime());
		crud.insert_policy(dao);
		return this;
	}
	
	public PolicyManager insertVulnsToDatabase(DAO_vulns dao) {
		CrudManager crud = new CrudManager();
		crud.insert_vulns(dao);
		return this;
	}
	
	private String getCurrentTime() {
		long time = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		return dayTime.format(new Date(time));
	}
}
