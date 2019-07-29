package berry.eva.application;

import org.eclipse.jface.viewers.ITreeContentProvider;

public class SiteTreeContentProvider implements ITreeContentProvider {

	// parentElement ����� ���� ��尡 �����ϴ� ��� �ڽ� ��� �迭�� �����Ѵ�.
	@Override
	public Object[] getChildren(Object parentElement) {
		return getElements(parentElement);
	}

	// inputElement ����� ���� ��尡 �����ϴ� ��� �ڽĳ�� �迭�� �����Ѵ�.
	@Override
	public Object[] getElements(Object inputElement) {
		return ((SiteNode)inputElement).getChild().toArray();
	}

	// ���� ����� �θ��尡 �����ϴ� ��� �θ��带 �����Ѵ�.
	// �θ��尡 null �� ��� Tree ���� �ֻ��� ��尡 �ȴ�.
	@Override
	public Object getParent(Object element) {
		if( element == null)
			return null;
		return ((SiteNode)element).getParent();
	}

	// �ڽ� ��尡 ������ �����ϴ��� ���� �� ���ȴ�.
	@Override
	public boolean hasChildren(Object element) {
		return ((SiteNode)element).getChild().size() > 0;
	}
	
}
