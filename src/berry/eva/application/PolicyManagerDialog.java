package berry.eva.application;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import berry.eva.evaluation.Weakness;
import berry.eva.evaluation.WeaknessEnumeration;
import berry.eva.policy.DTO_vulns;
import berry.eva.util.TextConverter;

public class PolicyManagerDialog extends TitleAreaDialog {

	private Label label_current_policy;
	private Label label_new_policy;
	private Text  text_new_policy;
	private Combo combo_policy;
	private Table table;
	private String newPolicyName;
	private List<DTO_vulns> list_vulns;
	
	public PolicyManagerDialog(Shell parentShell) {
		super(parentShell);

	}

	@Override
	public void create() {
		super.create();
		
		setTitle("Policy Manager");
		setMessage("Please check from the weakness list", IMessageProvider.INFORMATION);
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		area.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);
		
		initLabel(container);
		
		final ScrolledComposite scrolledComposite = new ScrolledComposite(container, SWT.NONE);
		scrolledComposite.setLayout(new GridLayout());
		scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		initTable(scrolledComposite);
		
		return area;
	}
	
	private void initLabel(Composite parent) {
		Composite innerContainer = new Composite(parent, SWT.NONE);
		innerContainer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(2, false);
		innerContainer.setLayout(layout);
		
		label_current_policy = new Label(innerContainer, SWT.BOLD);
		label_current_policy.setText("Select Policy : ");
		
		combo_policy = new Combo(innerContainer, SWT.DROP_DOWN | SWT.READ_ONLY);
		String[] items = new String[] { "default" };
		combo_policy.setItems(items);
		combo_policy.select(0);
		
		// TODO : LoadingPolicyFromDatabase
		label_new_policy = new Label(innerContainer, SWT.BOLD);
		label_new_policy.setText("New Policy Name");
		
		text_new_policy = new Text(innerContainer, SWT.BORDER);
		
	}
	
	private void LoadingPolicyFromDatabase(Composite container) {
		// TODO : Database setting
		
	}
	
	private void initTable(ScrolledComposite container) {
		
		table = new Table(container, SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		table.setHeaderVisible(true);
		
		container.setContent(table);
		container.setExpandHorizontal(true);
		container.setExpandVertical(true);
		container.setAlwaysShowScrollBars(true);
		
		TableColumn col_use = new TableColumn(table, SWT.CENTER);
		col_use.setText("use");
		col_use.setWidth(30);
		
		TableColumn col_available = new TableColumn(table, SWT.LEFT);
		col_available.setText("Available");
		col_available.setWidth(90);
		
		TableColumn col_category = new TableColumn(table, SWT.LEFT);
		col_category.setText("Category");
		col_category.setWidth(180);
		
		TableColumn col_cweid = new TableColumn(table, SWT.LEFT);
		col_cweid.setText("CWE_ID");
		col_cweid.setWidth(80);
		
		TableColumn col_attackName = new TableColumn(table, SWT.LEFT);
		col_attackName.setText("Attack Name");
		col_attackName.setWidth(280);
		
		TableColumn col_description = new TableColumn(table, SWT.LEFT);
		col_description.setText("Description");
		col_description.setWidth(450);
				
				
		initWeaknessEnumeration(table);
	}
	
	private void initWeaknessEnumeration(Table table) {
		
		Iterator<String> iter = WeaknessEnumeration.getInstance().keySet().iterator();
		while(iter.hasNext()) {
			String key_cwe_id = iter.next();
			Weakness weakness =  WeaknessEnumeration.getInstance().get(key_cwe_id);
			
			TableItem item = new TableItem(table, SWT.NONE);
			TableEditor editor = new TableEditor(table);
			Button button_use = new Button(table, SWT.CHECK);
			button_use.setEnabled( isAvailable(weakness.getAvailable()) );
			button_use.setSelection( isAvailable(weakness.getAvailable()));
			button_use.pack();
			editor.minimumWidth = button_use.getSize().x;
			editor.horizontalAlignment = SWT.CENTER;
			editor.setEditor(button_use, item, 0);
			item.setData("button_use", button_use);
			item.setText(1, TextConverter.IntToAvailable(weakness.getAvailable()));
			item.setText(2, weakness.getCategory().name());
			item.setText(3, weakness.getCwe_id());
			item.setText(4, weakness.getAttackName());
			item.setText(5, weakness.getDescription());
		}
	}
	
	private boolean isAvailable(Integer i) {
		return i==1? true : false;
	}

	private Integer isAvailable(boolean flag) {
		return flag == true? 1 : 0;
	}
	
	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected void okPressed() {
		
		newPolicyName = text_new_policy.getText();
		
		list_vulns = new ArrayList<DTO_vulns>();
		TableItem[] items = table.getItems();
		for(int i=0; i<items.length; i++) {
			
			Button btn = (Button) items[i].getData("button_use");
			Integer use = isAvailable(btn.getSelection());
			String cwe_id = items[i].getText(3);
			
			list_vulns.add(new DTO_vulns(use, cwe_id));
		}
		super.okPressed();
	}

	public String getNewPolicyName() {
		return this.newPolicyName;
	}
	
	public List<DTO_vulns> getDTOs(){
		return this.list_vulns;
	}
	
	public Label getLabel_current_policy() {
		return label_current_policy;
	}

	public Combo getCombo_policy() {
		return combo_policy;
	}

	public Table getTable() {
		return table;
	}
	
	
	
}
