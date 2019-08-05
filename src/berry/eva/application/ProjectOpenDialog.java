package berry.eva.application;

import java.util.List;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import berry.eva.database.CrudManager;
import berry.eva.database.dao.DAO_projects;
import berry.eva.project.ProjectManager;

public class ProjectOpenDialog extends TitleAreaDialog{

	private Label label_project;
	private Combo combo_project;
	private String projectName;
	
	public ProjectOpenDialog(Shell parentShell) {
		super(parentShell);

	}
	
	@Override
	public void create() {
		super.create();
		
		setTitle("Project Manager");
		setMessage("Please select the name of project", IMessageProvider.INFORMATION);
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);

		initComponents(container);
		
		return area;
	}

	private void initComponents(Composite parent) {
		Composite innerContainer = new Composite(parent, SWT.NONE);
		innerContainer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(2, false);
		innerContainer.setLayout(layout);
		
		label_project = new Label(innerContainer, SWT.BOLD);
		label_project.setText("Select Project : ");
		
		combo_project = new Combo(innerContainer, SWT.DROP_DOWN | SWT.READ_ONLY);
		
		combo_project.setItems(selectProjectNames());
		combo_project.select(0);
	}
	
	private String[] selectProjectNames() {

		CrudManager crud = new CrudManager();
		List<DAO_projects> list = crud.select_projects_all();
		int size = list.size();
		
		String[] items = new String[size];
		for(int i = 0; i<size; i++) {
			items[i] = new String(list.get(i).getProjectname());	
		}
		return items;
	}
	
	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected void okPressed() {
		this.projectName = combo_project.getText();
		super.okPressed();
	}
	
	public String getProjectName() {
		return this.projectName;
	}
	
}
