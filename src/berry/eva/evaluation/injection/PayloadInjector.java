package berry.eva.evaluation.injection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import berry.eva.core.Context;
import berry.eva.core.URLQueue;

public class PayloadInjector {

	private List<Context> list = new LinkedList<Context>();

	public void scanStart(URLQueue queue) {
		Iterator<String> iter = queue.iterator();
		while (iter.hasNext()) {
			String url = iter.next();

			// TODO :

		}

	}

}
