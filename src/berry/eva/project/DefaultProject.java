package berry.eva.project;

import berry.eva.policy.DefaultPolicy;

public class DefaultProject extends Project {

	public DefaultProject(String name) {
		super(name);
		super.addPolicy(new DefaultPolicy("default"));
	}

	
}
