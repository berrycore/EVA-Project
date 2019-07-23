package berry.eva.core;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContextManager {
	private ContextManager() {}
	private static ContextManager instance = new ContextManager();
	public static ContextManager getInstance() {
		return instance;
	}
	
		
	private static String getCurrentTime() {
		long time = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		return dayTime.format(new Date(time));
	}
}
