package berry.eva.application;

import java.awt.Color;

import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;

public class SpiderComposite extends Composite {

	TableViewer tableViewer;
	
	public SpiderComposite(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new FillLayout());
		tableViewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION);
		TableLayout layout = new TableLayout();
		layout.addColumnData(new ColumnWeightData(50,75, true));
		tableViewer.getTable().setLayout(layout);
		tableViewer.getTable().setLinesVisible(true);
		tableViewer.getTable().setHeaderVisible(true);
		tableViewer.setContentProvider(new SpiderContentProvider());
		tableViewer.setLabelProvider(new SpiderLabelProvider());
		TableColumn column1 = new TableColumn(tableViewer.getTable(), SWT.CENTER);
		column1.setText("link");
	}
	
}
