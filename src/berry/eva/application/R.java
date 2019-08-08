package berry.eva.application;

public class R {

	final public static String EVA_PROJECT = "EVA_PROJECT";
	final public static class TEXT{
		final public static String ERROR_MSG = "";
		final public static String UN_KNOWN = "UN_KNOWN";
		final public static String HElP_VERSION = "Version : 1.0.0";
		final public static String HELP_CONTACT = "We have created an automation program to check for web vulnerabilities. \n" + 
				"If you have any questions about bugs, please contact us at the following e-mail address.";
		final public static String HELP_EMAIL = "berrycore@gmail.com";
		final public static String WARNING = "This program is intended for vulnerability checking.\r\n" + 
				"It should only be used for internal checks and should not be used in any other system.\r\n" + 
				"In the event of a hacking incident, the user has legally responsible.";
	}
	
	final public static class KIND{
		final public static String SITE = "KIND_SITE";
		final public static String DIR = "KIND_DIR";
		final public static String FILE = "KIND_FILE";
	}
	
	final public static class MyBatis {
		final public static String NAME_SPACE = "berry.eva.database.myMapper";
		final public static String PATH_CONFIG = "berry/eva/database/mybatis_config.xml";
	}
	
	public static class HTTP_HEAD_CONFIG{
		public static String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64; rv:39.0) Gecko/20100101 Firefox/39.0";
		public static String pragma = "no-cache";
		public static String cacheControl = "no-cache";
		public static String cookie = "";
	}
}
