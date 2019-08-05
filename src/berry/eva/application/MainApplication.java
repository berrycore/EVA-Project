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
		return this.startComposite;
	}

	public SpiderComposite getSpiderComposite() {
		return this.spiderComposite;
	}

	public ScanComposite getScanComposite() {
		return this.scanComposite;
	}

	public ReqRespComposite getReqRespComposite() {
		return this.reqRespComposite;
	}
	
	public TreeViewer getTreeViewer() {
		return this.treeViewer;
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
		//treeViewer.setInput(SiteNodeManager.getInstance().createTestTree());
		treeViewer.setInput(SiteNodeManager.getInstance().createDefaultTree());

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

		sash_vertical.setWeights(new int[] { 5, 5 });
		sash_horizontal.setWeights(new int[] { 2, 8 });

		setStatus("Status is ready!");
		return parent;
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
				ProjectCreateDialog dialog = new ProjectCreateDialog(getShell());
				dialog.create();
				if (dialog.open() == Window.OK) {
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
				ProjectOpenDialog dialog = new ProjectOpenDialog(getShell());
				dialog.create();
				if (dialog.open() == Window.OK) {
					String projectName = dialog.getProjectName();
					MainApplication.this.getShell().setText(R.EVA_PROJECT + " : " + projectName);
				}

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
				PolicyManagerDialog dialog = new PolicyManagerDialog(getShell());
				dialog.create();
				if (dialog.open() == Window.OK) {
					// TODO : get 으로 받아서 DB 나 Manager 으로 저장하기
					
				}
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
				return "&Contact";
			}

			@Override
			public void run() {
				HelpDialog dialog = new HelpDialog(getShell());
				dialog.create();
				dialog.open();
			}

		});

		menu.add(new Action() {
			@Override
			public String getText() {
				return "&Reference";
			}

			@Override
			public void run() {
				ReferenceDialog dialog = new ReferenceDialog(getShell());
				dialog.create();
				if (dialog.open() == Window.OK) {
					
				}
			}
		});

		return menu;
	}

}
