package berry.eva.project;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import berry.eva.policy.Policy;

public class Project {

	private String name;
	private String createdtime;
	private List<Policy> policies = new ArrayList<Policy>();

	public Project() {
		
	}
	
	public Project(String name) {
		this.name = name;
	}
	
	public Project(String name, String createdtime) {
		this.name = name;
		this.createdtime = createdtime;
	}
	
	public void addPolicy(Policy p) {
		this.policies.add(p);
	}
	
	public List<Policy> getPolicies(){
		return policies;
	}

	public String getName() {
		return this.name;
	}
	
	public void setCreatedTime(String time) {
		this.createdtime = time;
	}
	
	public String getCreatedTime() {
		return this.createdtime;
	}

//	private String getCurrentTime() {
//		long time = System.currentTimeMillis();
//		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//		return dayTime.format(new Date(time));
//	}
//	
	
}
