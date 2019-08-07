package berry.eva.policy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import berry.eva.evaluation.Vulnerable;

public class Policy {

	private String policyName;
	private String projectName;
	private List<Vulnerable> list_vulnerable;
	
	public Policy(String projectName,String policyName) {
		this.projectName = projectName;
		this.policyName = policyName;
		this.list_vulnerable = new ArrayList<Vulnerable>();
	}
	
	public Iterator<Vulnerable> iterator(){
		return this.iterator();
	}
	
	public String getPolicyName() {
		return this.policyName;
	}
	
	public String getProjectName() {
		return this.projectName;
	}
	
	public boolean add(Vulnerable vulnerable) {
		return this.list_vulnerable.add(vulnerable);
	}
	
	public boolean isEmpty() {
		return this.list_vulnerable.isEmpty();
	}
	
	public Vulnerable get(int index) {
		return this.list_vulnerable.get(index);
	}
	
	public List<Vulnerable> getList(){
		return this.list_vulnerable;
	}
	
	public int size() {
		return this.list_vulnerable.size();
	}
}
