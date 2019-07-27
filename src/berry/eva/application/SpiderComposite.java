package berry.eva.application;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class SpiderComposite extends Composite {

	private Table table;
	private ProgressBar progressBar;
	

	public SpiderComposite(Composite parent, int style) {
		super(parent, style);
		// this.setLayout(new FillLayout(SWT.VERTICAL));
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		this.setLayout(gridLayout);

		
		initProgressBar();
		initTable();
	}

	public Table getTable() {
		return this.table;
	}
	
	private void initTable() {
		final ScrolledComposite composite = new ScrolledComposite(this, SWT.NONE);
		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		table = new Table(composite, SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		table.setHeaderVisible(true);

		composite.setContent(table);
		composite.setExpandHorizontal(true);
		composite.setExpandVertical(true);
		composite.setAlwaysShowScrollBars(true);
		composite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		// TableColumn setting
		TableColumn column1 = new TableColumn(table, SWT.CENTER);
		column1.setText("URL");
		column1.setWidth(400);
		
		TableColumn column2 = new TableColumn(table, SWT.CENTER);
		column2.setText("Flags");
		column2.setWidth(80);
		
////		for (int col = 0; col < table.getColumnCount(); col++) {
////			table.getColumn(col).pack();
////		}
//
//		TableItem item = new TableItem(table, SWT.NONE);
//		item.setText(0, "http://127.0.0.1:8188/dummy");
//		item.setText(1, "n");
		
	}

	private void initProgressBar() {
		Composite innerComposite = new Composite(this, SWT.NONE);
		innerComposite.setLayout(new GridLayout(1, true));
		progressBar = new ProgressBar(innerComposite, SWT.NONE);
		progressBar.setBounds(new Rectangle(0, 0, 150, 15));
	}
}
