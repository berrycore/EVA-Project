package berry.eva.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ContextManager {
	
	private static ContextManager instance = new ContextManager();
	public static ContextManager getInstance() {
		return instance;
	}

	private Map<Integer, Context> map = new HashMap<Integer, Context>();

	private ContextManager() {
		
	}

	public void put(Integer key, Context context) {
		map.put(key, context);
	}

	public Context get(Integer key) {
		return map.get(key);
	}

	public Set<Integer> keySet(){
		return map.keySet();
	}

	public boolean containsKey(Integer key){
		return map.containsKey(key);
	}
	
	public boolean containsValue(Context context) {
		return map.containsValue(context);
	}
}
