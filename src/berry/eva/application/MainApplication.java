package berry.eva.application;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public final class MainApplication extends ApplicationWindow {

	public MainApplication() {
		super(null);
		this.addMenuBar();
		this.addStatusLine();
		
	}

	@Override
	protected Control createContents(Composite parent) {
//		TODO : layout!!
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
				
		
		TreeViewer tv = new TreeViewer(composite);
		tv.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
		tv.setLabelProvider(new SiteTreeLabelProvider());
		tv.setContentProvider(new SiteTreeContentProvider());
		tv.setInput("root");
		
		setStatus("Status is ready!");
		return composite;
	}
	
	
	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setSize(500, 400);
		shell.setText("EVA-Project");
		
	}

	

	@Override
	protected MenuManager createMenuManager() {

		MenuManager menuManager = new MenuManager("");
		menuManager.add(createFileMenu());
		menuManager.add(createSettingMenu());
		menuManager.add(createHelpMenu());

		return menuManager;
	}

	protected MenuManager createFileMenu() {
		MenuManager menu = new MenuManager("&File", "Id01");
		menu.add(new Action() {

			@Override
			public void run() {
				String[] buttons = { IDialogConstants.OK_LABEL, IDialogConstants.CANCEL_LABEL };
				MessageDialog dialog = new MessageDialog(getShell(), "Title", null, "File/Open selected!",
						MessageDialog.INFORMATION, buttons, 0);
				dialog.open();
			}

			@Override
			public String getText() {
				return "&Open";
			}

		});
		
		menu.add(new Action() {
			@Override
			public String getText() {
				return "&Save";
			}

			@Override
			public void run() {
				// TODO:
			}
		});

		menu.add(new Action() {

			@Override
			public String getText() {
				return "E&xit";
			}

			@Override
			public void run() {
				MainApplication.this.getShell().close();
			}

		});

		return menu;
	}
	
	protected MenuManager createSettingMenu() {
		MenuManager menu = new MenuManager("&Setting", "Id02");
		menu.add(new Action() {

			@Override
			public String getText() {
				return "&Policy";
			}

			@Override
			public void run() {
				// TODO :
			}
			
		});
		
		menu.add(new Action() {

			@Override
			public String getText() {
				return "&Config";
			}

			@Override
			public void run() {
				// TODO : 
			}
			
		});
		
		return menu;
	}
	
	protected MenuManager createHelpMenu() {
		MenuManager menu = new MenuManager("&Help", "Id03");
		menu.add(new Action() {

			@Override
			public String getText() {
				return "&Help Contents";
			}

			@Override
			public void run() {
				// TODO :
			}
			
		});
		
		menu.add(new Action() {
			@Override
			public String getText() {
				return "&Reference";
			}

			@Override
			public void run() {
				// TODO :
			}
		});
		
		return menu;
	}

}
