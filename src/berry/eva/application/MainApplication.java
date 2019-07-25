package berry.eva.application;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

public final class MainApplication extends ApplicationWindow {

	public MainApplication() {
		super(null);
		this.addMenuBar();
		this.addStatusLine();
		
	}

	@Override
	protected Control createContents(Composite parent) {
			
		SashForm sash_vertical = new SashForm(parent, SWT.VERTICAL);
		SashForm sash_horizontal = new SashForm(sash_vertical, SWT.HORIZONTAL);
		sash_vertical.setSashWidth(5);
		sash_horizontal.setSashWidth(5);
				
		TreeViewer treeViewer = new TreeViewer(sash_horizontal);
		treeViewer.getTree().setLayoutData(new GridData(GridData.FILL_VERTICAL));
		treeViewer.setLabelProvider(new SiteTreeLabelProvider());
		treeViewer.setContentProvider(new SiteTreeContentProvider());
		treeViewer.setInput("root");
		
		Text text = new Text(sash_horizontal, SWT.FLAT);
		text.setText("Main input!!");
		
		TabFolder folder = new TabFolder(sash_vertical, SWT.NONE);
		TabItem tab_spider = new TabItem(folder, SWT.NONE);
		tab_spider.setText("Spider");
		
		Text text_spider = new Text(folder, SWT.BOLD);
		text_spider.setText("Table Here !!");
		tab_spider.setControl(text_spider);
		
		
		TabItem tab_scan = new TabItem(folder, SWT.NONE);
		tab_scan.setText("Scan");
		
		Text text_scan = new Text(folder, SWT.ITALIC);
		text_scan.setText("Table HERE!!!");
		tab_scan.setControl(text_scan);
		
		sash_vertical.setWeights(new int[] {6,4});
		sash_horizontal.setWeights(new int[] {2,8});
		
		setStatus("Status is ready!");
		return parent;
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
