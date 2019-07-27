package berry.eva.application;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ProjectManagerDialog extends TitleAreaDialog {

	private Text text_projectName;
	private String projectName;
	
	public ProjectManagerDialog(Shell parentShell) {
		super(parentShell);

	}

	@Override
	public void create() {
		super.create();
		
		setTitle("Project Manager");
		setMessage("Please input the name of new Project", IMessageProvider.INFORMATION);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);
		
		createProjectName(container);
		
		return area;
	}
	
	private void createProjectName(Composite container) {
		Label label_project_name = new Label(container, SWT.NONE);
		label_project_name.setText("Project Name : ");
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		
		text_projectName = new Text(container, SWT.BORDER);
		text_projectName.setLayoutData(gridData);
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected void okPressed() {
		this.projectName = text_projectName.getText();
		super.okPressed();
	}
	
	public String getProjectName() {
		return this.projectName;
	}

}
