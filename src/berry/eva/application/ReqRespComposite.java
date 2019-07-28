package berry.eva.application;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;

public class ReqRespComposite extends Composite {

	private Text text_request_header;
	private Text text_request_body;
	private Text text_response_header;
	private Text text_response_body;
	
	public ReqRespComposite(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new FillLayout());
		initTextArea();
	}

	private void initTextArea() {
		
		SashForm sashForm_main = new SashForm(this, SWT.HORIZONTAL);
		
		Group group_request = new Group(sashForm_main, SWT.SHADOW_IN);
		group_request.setText("HTTP Request");
		group_request.setLayout(new FillLayout());
		
		Group group_response = new Group(sashForm_main, SWT.SHADOW_IN);
		group_response.setText("HTTP Response");
		group_response.setLayout(new FillLayout());
		
		SashForm sashForm_request = new SashForm(group_request, SWT.VERTICAL);
		
		
		text_request_header = new Text(sashForm_request, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		text_request_body = new Text(sashForm_request, SWT.BORDER |  SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		
		SashForm sashForm_response = new SashForm(group_response, SWT.VERTICAL);
		
		text_response_header = new Text(sashForm_response, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		text_response_body = new Text(sashForm_response, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		
		// dummy text
		text_request_header.setText("text_request_header");
		text_request_body.setText("text_request_body");
		text_response_header.setText("text_response_header");
		text_response_body.setText("text_response_body");
		
		sashForm_main.setWeights(new int[] { 5, 5});
		sashForm_request.setWeights(new int[] {4,6});
		sashForm_response.setWeights(new int[] {4,6});
	}

	public Text getText_request_header() {
		return text_request_header;
	}

	public Text getText_request_body() {
		return text_request_body;
	}

	public Text getText_response_header() {
		return text_response_header;
	}

	public Text getText_response_body() {
		return text_response_body;
	}
	
	
}
