package berry.eva.core;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContextManager {
	private List<Context> list_context;

	private ContextManager() {
		list_context = new LinkedList<Context>();
	}

	public boolean add(Context context) {
		return list_context.add(context);
	}

	public Context get(int index) {
		return list_context.get(index);
	}

	public boolean isEmpty() {
		return list_context.isEmpty();
	}

	public Iterator<Context> iterator() {
		return list_context.iterator();
	}

	public int size() {
		return list_context.size();
	}

//	private static String getCurrentTime() {
//		long time = System.currentTimeMillis();
//		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//		return dayTime.format(new Date(time));
//	}
}
