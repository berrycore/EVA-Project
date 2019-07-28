package berry.eva.policy;

import berry.eva.evaluation.scan.HTTPMethodScan;

public class DefaultPolicy extends Policy {

	public DefaultPolicy(String name) {
		super(name);
		
		initSetting();
	}

	private void initSetting() {
		super.add(new HTTPMethodScan());		
	}

	
}
