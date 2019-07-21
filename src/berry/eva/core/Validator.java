package berry.eva.core;

public final class Validator {

	private static Validator instance = new Validator();
	private Validator() {};
	
	public static Validator getInstance() {
		return instance;
	}
	

	public static boolean isinScope(String url) {
		SearchEngine engine = SearchEngine.getInstance();
		String domain = engine.getCurrentDomain();
		return url.contains(domain);
	}
	
}
