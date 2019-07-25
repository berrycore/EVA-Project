package berry.eva.application;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;

public class SpiderContentProvider implements IStructuredContentProvider {

	@Override
	public Object[] getElements(Object element) {
		// TODO Auto-generated method stub
		return ((List<String>)element).toArray();
	}

}
