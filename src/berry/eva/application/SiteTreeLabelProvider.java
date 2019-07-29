package berry.eva.application;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

public class SiteTreeLabelProvider implements ILabelProvider{

	private Image site;
	private Image folder;
	private Image file;
	
	public SiteTreeLabelProvider() {
		site = new Image(null, "images/site.png");
		folder = new Image(null, "images/folder.png");
		file = new Image(null, "images/file.png");
	}
	
	 @Override
     public String getText(Object element) {
		 SiteNode node = (SiteNode)element;
		 return node.getContents();
     }

	 
	// 노드에 표시될 이미지를 리턴한다.
	@Override
	public Image getImage(Object element) {
		SiteNode node = (SiteNode)element;
		if(node.getKind().equals(R.TEXT.KIND_SITE)) {
			return site;
		}else if(node.getKind().equals(R.TEXT.KIND_DIR)) {
			return folder;
		}else if(node.getKind().equals(R.TEXT.KIND_FILE)){
			return file;
		}
		return null;
	}


	@Override
	public void addListener(ILabelProviderListener arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean isLabelProperty(Object arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void removeListener(ILabelProviderListener arg0) {
		// TODO Auto-generated method stub
		
	}
	 
	 

}
