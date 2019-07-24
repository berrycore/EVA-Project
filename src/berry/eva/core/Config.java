package berry.eva.core;

import java.util.HashMap;
import java.util.Map;

import berry.eva.evaluation.Weakness;

public class Config {

	private String name;
	private Map<String, Weakness> selected_map = new HashMap<String, Weakness>();

	public Config(String name) {
		this.name = name;
	}
	
	
	
	
}
