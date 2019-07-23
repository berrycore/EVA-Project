package berry.eva.core;

import java.util.LinkedList;
import java.util.List;

public class ContextManager {
	private ContextManager() {}
	private static ContextManager instance = new ContextManager();
	public static ContextManager getInstance() {
		return instance;
	}
	
	private List<Context> list_context = new LinkedList<Context>();
	
	public List<Context> getList(){
		return this.list_context;
	}
		
//	private static String getCurrentTime() {
//		long time = System.currentTimeMillis();
//		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//		return dayTime.format(new Date(time));
//	}
}
