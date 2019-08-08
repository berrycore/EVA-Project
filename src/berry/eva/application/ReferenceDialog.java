package berry.eva.application;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;

public class ReferenceDialog extends TitleAreaDialog {

	public ReferenceDialog(Shell parentShell) {
		super(parentShell);

	}

	@Override
	public void create() {
		super.create();
		
		setTitle("Reference");
		//setMessage("Link", IMessageProvider.INFORMATION);
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);

		showRefereceLink(container);
		
		return area;
	}

	private void showRefereceLink(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new RowLayout(SWT.VERTICAL));
		Group group = new Group(container, SWT.SHADOW_IN);
		group.setText("About. Web Security");
		group.setFont(new Font(getShell().getDisplay(), "Consolas", 12, SWT.NONE));
		group.pack();
		
		
		Link link_owasp = new Link(group, SWT.ITALIC);
		
		link_owasp.setText("<a href=\"https://owasp.org/\">https://owasp.org/</a>");
		link_owasp.setLocation(20, 20);
		link_owasp.setFont(new Font(getShell().getDisplay(), "Consolas", 12, SWT.NONE));
		link_owasp.pack();
		link_owasp.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Program.launch("https://owasp.org/");
			}
			
		});
		
		Link link_cwe = new Link(group, SWT.ITALIC);
		link_cwe.setText("<a href=\"https://cwe.mitre.org/\">https://cwe.mitre.org/</a>");
		link_cwe.setFont(new Font(getShell().getDisplay(), "Consolas", 12, SWT.NONE));
		link_cwe.setLocation(20, 40);
		link_cwe.pack();
		link_cwe.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Program.launch("https://cwe.mitre.org/");
			}
			
		});
	}
	
	@Override
	protected boolean isResizable() {
		return true;
	}


}
