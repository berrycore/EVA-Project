package berry.eva.policy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import berry.eva.evaluation.Weakness;

public class Policy {

	private String name;
	private List<Weakness> list_weakness;
	
	public Policy(String name) {
		this.name = name;
		this.list_weakness = new ArrayList<Weakness>();
	}
	
	public Iterator<Weakness> iterator(){
		return this.iterator();
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean add(Weakness weakness) {
		return this.list_weakness.add(weakness);
	}
	
	public boolean isEmpty() {
		return this.list_weakness.isEmpty();
	}
	
	public Weakness get(int index) {
		return this.list_weakness.get(index);
	}
}
