package berry.eva.core;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import berry.eva.project.Project;

public class ContextManager {
	
	private Project project;
	private List<Context> list_context;

	public ContextManager(Project project) {
		this.project = project;
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
	
	public Project getProject() {
		return project;
	}
}
