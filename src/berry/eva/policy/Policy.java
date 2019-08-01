package berry.eva.policy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import berry.eva.evaluation.Vulnerable;

public class Policy {

	private String name;
	private List<Vulnerable> list_vulnerable;
	
	public Policy(String name) {
		this.name = name;
		this.list_vulnerable = new ArrayList<Vulnerable>();
	}
	
	public Iterator<Vulnerable> iterator(){
		return this.iterator();
	}
	
	public String getName() {
		return this.name;
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
