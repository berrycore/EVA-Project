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

public class ScanComposite extends Composite {
	
	Table table;
	ProgressBar progressBar;

	public ScanComposite(Composite parent, int style) {
		super(parent, style);
		// this.setLayout(new FillLayout(SWT.VERTICAL));
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		this.setLayout(gridLayout);

		initProgressBar();
		initTable();

	}

	private void initTable() {
		final ScrolledComposite composite = new ScrolledComposite(this, SWT.NONE);
		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		final Table table = new Table(composite, SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
		table.setHeaderVisible(true);

		composite.setContent(table);
		composite.setExpandHorizontal(true);
		composite.setExpandVertical(true);
		composite.setAlwaysShowScrollBars(true);
		composite.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));

		for (int col = 0; col < 4; col++) {
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText("Column " + col);
		}

		for (int col = 0; col < table.getColumnCount(); col++) {
			table.getColumn(col).pack();
		}

		for (int row = 0; row < 20; row++) {
			TableItem item = new TableItem(table, SWT.NONE);

			for (int col = 0; col < table.getColumnCount(); col++) {
				item.setText(col, "Item " + row + " " + col);
			}
		}
	}

	private void initProgressBar() {
		Composite innerComposite = new Composite(this, SWT.NONE);
		innerComposite.setLayout(new GridLayout(1, true));
		progressBar = new ProgressBar(innerComposite, SWT.NONE);
		progressBar.setBounds(new Rectangle(0, 0, 150, 15));
	}
}
