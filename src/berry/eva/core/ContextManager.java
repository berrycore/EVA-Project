package berry.eva.core;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContextManager {
	
	private static ContextManager instance = new ContextManager();
	
	private ContextManager() {}
	
	public static ContextManager getInstance() {
		return instance;
	}
	
	private static Integer count = 1;

	public static Context generate(String url) {
		Context context = new Context();
		context.setIndex(count++);
		context.setTime_request(getCurrentTime());
		context.setUrl(url);
		context.setScanned(false);
		return context;
	}
	
	private static String getCurrentTime() {
		long time = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		return dayTime.format(new Date(time));
	}
}
