package berry.eva.application;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

public class SiteTreeLabelProvider implements ILabelProvider{

	 @Override
     public String getText(Object element) {
		 return element.toString();
     }

	 
	// ��忡 ǥ�õ� �̹����� �����Ѵ�.
	@Override
	public Image getImage(Object element) {
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
