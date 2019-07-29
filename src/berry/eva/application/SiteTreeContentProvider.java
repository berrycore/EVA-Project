package berry.eva.application;

import org.eclipse.jface.viewers.ITreeContentProvider;

public class SiteTreeContentProvider implements ITreeContentProvider {

	// parentElement 노드의 하위 노드가 존재하는 경우 자식 노드 배열을 리턴한다.
	@Override
	public Object[] getChildren(Object parentElement) {
		return getElements(parentElement);
	}

	// inputElement 노드의 하위 노드가 존재하는 경우 자식노드 배열을 리턴한다.
	@Override
	public Object[] getElements(Object inputElement) {
		return ((SiteNode)inputElement).getChild().toArray();
	}

	// 현재 노드의 부모노드가 존재하는 경우 부모노드를 리턴한다.
	// 부모노드가 null 인 경우 Tree 에서 최상위 노드가 된다.
	@Override
	public Object getParent(Object element) {
		if( element == null)
			return null;
		return ((SiteNode)element).getParent();
	}

	// 자식 노드가 실제로 존재하는지 검증 시 사용된다.
	@Override
	public boolean hasChildren(Object element) {
		return ((SiteNode)element).getChild().size() > 0;
	}
	
}
