package berry.eva.core;

public final class Validator {

	private static Validator instance = new Validator();
	private Validator() {};
	
	public static Validator getInstance() {
		return instance;
	}
	

}
