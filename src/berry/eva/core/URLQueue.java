package berry.eva.core;

import java.util.LinkedList;
import java.util.Queue;

public final class URLQueue {

	private Queue<Context> queue = new LinkedList<Context>();
	private static URLQueue instance = new URLQueue();

	private URLQueue() {
	};

	public static URLQueue getInstance() {
		return instance;
	}

//	public synchronized Context peek() {
//		return queue.peek();
//	}

	public synchronized Context poll() {
		return queue.poll();
	}

	public synchronized boolean offer(Context context) {
		return queue.offer(context);
	}

	public synchronized boolean isEmpty() {
		return queue.isEmpty();
	}
	
	public synchronized boolean clearAll() {
		return queue.removeAll(queue);
	}

}
