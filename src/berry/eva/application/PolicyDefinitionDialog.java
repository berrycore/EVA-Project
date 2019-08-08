package berry.eva.application;

import java.util.List;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import berry.eva.database.CrudManager;
import berry.eva.database.dao.DAO_policy;

public class PolicyDefinitionDialog extends TitleAreaDialog {

	private Label label_policy;
	private Label label_new_policy;
	private Label label_output;
	private Text text_new_policy;
	private String availablePolicyNames = selectPolicyNames();
	private String newPolicyName;
			
	public PolicyDefinitionDialog(Shell parentShell) {
		super(parentShell);

	}

	@Override
	public void create() {
		super.create();

		setTitle("Policy Definition");
		setMessage("Please check your policy", IMessageProvider.INFORMATION);
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

		label_policy = new Label(innerContainer, SWT.BOLD);
		label_policy.setText("Available Policy : ");

		label_output = new Label(innerContainer, SWT.BOLD);
		label_output.setText(availablePolicyNames);
		Font font = new Font(parent.getDisplay(), "Arial", 12, SWT.ITALIC);
		label_output.setFont(font);
		
		label_new_policy = new Label(innerContainer, SWT.BOLD);
		label_new_policy.setText("New Policy Name");
		
		text_new_policy = new Text(innerContainer, SWT.BORDER);
	}

	private String selectPolicyNames() {

		StringBuffer buffer = new StringBuffer();
		CrudManager crud = new CrudManager();
		List<DAO_policy> list = crud.select_policys_all();
		int size = list.size();
		
		System.out.println(size);
		System.out.println(list);

		for (int i = 0; i < size; i++) {
			
			buffer.append(list.get(i).getPolicyname()+"\n");
		}
		
		return buffer.toString();

	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected void okPressed() {
		this.newPolicyName = text_new_policy.getText();
		super.okPressed();
	}
	
	public String getNewPolicyName() {
		return this.newPolicyName;
	}
}
