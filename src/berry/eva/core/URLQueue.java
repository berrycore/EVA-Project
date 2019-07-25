package berry.eva.core;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public final class URLQueue {

	private Queue<String> queue = new LinkedList<String>();
	private static URLQueue instance = new URLQueue();

	private URLQueue() {
	};

	public static URLQueue getInstance() {
		return instance;
	}

	public synchronized String poll() {
		String url = queue.poll();
		System.out.println("[" + queue.size() + "] poll : " + url);
		return url;
	}

	public synchronized boolean offer(String url) {
		
		if(queue.contains(url)) {
			System.out.println("[" + queue.size() + "] 포함 : " + url);
			return false;
		}else {
			System.out.println("[" + queue.size() + "] not 포함 : offer!! : " + url);
			return queue.offer(url);	
		}
	}
	
	public Iterator<String> iterator(){
		return this.iterator();
	}

	public synchronized int getSize() {
		return queue.size();
	}
	
	public synchronized boolean isEmpty() {
		return queue.isEmpty();
	}

	public synchronized boolean clearAll() {
		return queue.removeAll(queue);
	}
	
	public synchronized String peek() {
		return queue.peek();
	}

	public List<String> getList(){
		return (List<String>) queue;
	}
}
