package berry.eva.application;

import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.TreeItem;

import berry.eva.database.CrudManager;
import berry.eva.project.Project;
import berry.eva.project.ProjectManager;

public final class MainApplication extends ApplicationWindow {
	private static MainApplication instance;
	public static MainApplication getInstance() {
		return instance;
	}
	
	private StartComposite startComposite;
	private ReqRespComposite reqRespComposite;
	private SpiderComposite spiderComposite;
	private ScanComposite scanComposite;
	private TabFolder folder_start;
	private TabFolder folder_crawler;
	private TreeViewer treeViewer;
	
	public StartComposite getStartComposite() {
		return startComposite;
	}

	public SpiderComposite getSpiderComposite() {
		return spiderComposite;
	}

	public ScanComposite getScanComposite() {
		return scanComposite;
	}
	
	public ReqRespComposite getReqRespComposite() {
		return reqRespComposite;
	}

	public MainApplication() {
		super(null);
		this.addMenuBar();
		this.addStatusLine();
		instance = this;
	}
	

	@Override
	protected Control createContents(Composite parent) {
			
		SashForm sash_vertical = new SashForm(parent, SWT.VERTICAL);
		SashForm sash_horizontal = new SashForm(sash_vertical, SWT.HORIZONTAL);
		sash_vertical.setSashWidth(5);
		sash_horizontal.setSashWidth(5);
		sash_vertical.setLayout(new FillLayout());
		sash_horizontal.setLayout(new FillLayout());
		
		SiteTreeLabelProvider labelProvider = new SiteTreeLabelProvider();
		SiteTreeContentProvider contentProvider = new SiteTreeContentProvider();
		
		treeViewer = new TreeViewer(sash_horizontal);
		treeViewer.getTree().setLayoutData(new GridData(GridData.FILL_VERTICAL));
		treeViewer.setLabelProvider(labelProvider);
		treeViewer.setContentProvider(contentProvider);
		treeViewer.setInput(createDummyTree());
		
		folder_start = new TabFolder(sash_horizontal, SWT.NONE);
		TabItem tab_quick = new TabItem(folder_start, SWT.NONE);
		tab_quick.setText("Start");
		
		startComposite = new StartComposite(this, folder_start, SWT.NONE);
		tab_quick.setControl(startComposite);
		
		TabItem tab_request_response = new TabItem(folder_start, SWT.NONE);
		tab_request_response.setText("Request & Response");
		
		reqRespComposite = new ReqRespComposite(folder_start, SWT.NONE);
		tab_request_response.setControl(reqRespComposite);
		
		
		folder_crawler = new TabFolder(sash_vertical, SWT.NONE);
		TabItem tab_spider = new TabItem(folder_crawler, SWT.NONE);
		tab_spider.setText("Spider");
		
		spiderComposite = new SpiderComposite(folder_crawler, SWT.NONE);
		tab_spider.setControl(spiderComposite);
		
		
		TabItem tab_scan = new TabItem(folder_crawler, SWT.NONE);
		tab_scan.setText("Scan");
		
		scanComposite = new ScanComposite(folder_crawler, SWT.NONE);
		tab_scan.setControl(scanComposite);
		
		sash_vertical.setWeights(new int[] {5,5});
		sash_horizontal.setWeights(new int[] {2,8});
		
		setStatus("Status is ready!");
		return parent;
	}
	
	
	
	private SiteNode createDummyTree() {
		SiteNode dummy = new SiteNode(null, R.TEXT.KIND_SITE, "dummy");
		SiteNode root = new SiteNode(dummy, R.TEXT.KIND_SITE, "site");
		SiteNode dir1 = new SiteNode(root, R.TEXT.KIND_DIR, "directory1");
		SiteNode dir2 = new SiteNode(root, R.TEXT.KIND_DIR, "directory2");
		SiteNode file1 = new SiteNode(dir1, R.TEXT.KIND_FILE, "file1");
		SiteNode file2 = new SiteNode(dir1, R.TEXT.KIND_FILE, "file2");
		SiteNode file3 = new SiteNode(dir2, R.TEXT.KIND_FILE, "file2");
		
		dummy.getChild().add(root);
		
		root.getChild().add(dir1);
		root.getChild().add(dir2);
		
		dir1.getChild().add(file1);
		dir1.getChild().add(file2);
		dir2.getChild().add(file3);
		
		return dummy;
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setSize(1200, 600);
		shell.setText(R.EVA_PROJECT);
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
				ProjectManagerDialog dialog = new ProjectManagerDialog(getShell());
				dialog.create();
				if( dialog.open() == Window.OK ) {
					String projectName = dialog.getProjectName();
					Project project = new Project(projectName);
					ProjectManager.getInstance().add(project);
					ProjectManager.getInstance().createNewTables(project);
					getShell().setText(R.EVA_PROJECT + " : " + projectName);
				}
			}

			@Override
			public String getText() {
				return "&New Project";
			}

		});
		
		menu.add(new Action() {

			@Override
			public void run() {
				String[] buttons = { IDialogConstants.OK_LABEL, IDialogConstants.CANCEL_LABEL };
				MessageDialog dialog = new MessageDialog(getShell(), "Title", null, "File/Open selected!",
						MessageDialog.INFORMATION, buttons, 0);
				dialog.open();
				
				// TEST open project list from database;
				CrudManager crud = new CrudManager();
				List<Object> list = crud.select_projects_all();
				System.out.println(list);
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
