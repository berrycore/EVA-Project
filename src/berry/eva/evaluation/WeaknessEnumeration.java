package berry.eva.evaluation;

import java.util.HashMap;
import java.util.Map;
import berry.eva.evaluation.Category;

public class WeaknessEnumeration {

	private static WeaknessEnumeration instance = new WeaknessEnumeration();
	
	public static WeaknessEnumeration getInstance() {
		return instance;
	}
	
	private Map<String, Weakness> map = new HashMap<String, Weakness>();
	
	private WeaknessEnumeration() {
		//TODO : form Databases;
		
		// dummy data
		Weakness CWE_77 = new Weakness(Category.Injection, "CWE_77", "Improper Neutralization of Special Elements used in a Command ('Command Injection')", "The software constructs all or part of a command using externally-influenced input from an upstream component, but it does not neutralize or incorrectly neutralizes special elements that could modify the intended command when it is sent to a downstream component.");
		Weakness CWE_78 = new Weakness(Category.Injection, "CWE_78", "Improper Neutralization of Special Elements used in an OS Command ('OS Command Injection')", "The software constructs all or part of an OS command using externally-influenced input from an upstream component, but it does not neutralize or incorrectly neutralizes special elements that could modify the intended OS command when it is sent to a downstream component.");
		Weakness CWE_88 = new Weakness(Category.Injection, "CWE_88", "Argument Injection or Modification", "The software does not sufficiently delimit the arguments being passed to a component in another control sphere, allowing alternate arguments to be provided, leading to potentially security-relevant changes.");
		Weakness CWE_89 = new Weakness(Category.Injection, "CWE_89", "Improper Neutralization of Special Elements used in an SQL Command ('SQL Injection')", "The software constructs all or part of an SQL command using externally-influenced input from an upstream component, but it does not neutralize or incorrectly neutralizes special elements that could modify the intended SQL command when it is sent to a downstream component.");
		Weakness CWE_90 = new Weakness(Category.Injection, "CWE_90", "Improper Neutralization of Special Elements used in an LDAP Query ('LDAP Injection')", "The software constructs all or part of an LDAP query using externally-influenced input from an upstream component, but it does not neutralize or incorrectly neutralizes special elements that could modify the intended LDAP query when it is sent to a downstream component.");
		Weakness CWE_91 = new Weakness(Category.Injection, "CWE_91", "XML Injection (aka Blind XPath Injection)", "The software does not properly neutralize special elements that are used in XML, allowing attackers to modify the syntax, content, or commands of the XML before it is processed by an end system.");
		Weakness CWE_564 = new Weakness(Category.Injection, "CWE_564", "SQL Injection: Hibernate", "Using Hibernate to execute a dynamic SQL statement built with user-controlled input can allow an attacker to modify the statement's meaning or to execute arbitrary SQL commands.");
		Weakness CWE_917 = new Weakness(Category.Injection, "CWE_917", "Improper Neutralization of Special Elements used in an Expression Language Statement ('Expression Language Injection')", "The software constructs all or part of an expression language (EL) statement in a Java Server Page (JSP) using externally-influenced input from an upstream component, but it does not neutralize or incorrectly neutralizes special elements that could modify the intended EL statement before it is executed.");
		Weakness CWE_943 = new Weakness(Category.Injection, "CWE_943", "Improper Neutralization of Special Elements in Data Query Logic", "The application generates a query intended to access or manipulate data in a data store such as a database, but it does not neutralize or incorrectly neutralizes special elements that can modify the intended logic of the query.");
		
		Weakness CWE_256 = new Weakness(Category.BrokenAuthentication, "CWE_256", "Unprotected Storage of Credentials", "Storing a password in plaintext may result in a system compromise.");
		Weakness CWE_287 = new Weakness(Category.BrokenAuthentication, "CWE_287", "Improper Authentication", "When an actor claims to have a given identity, the software does not prove or insufficiently proves that the claim is correct.");
		Weakness CWE_308 = new Weakness(Category.BrokenAuthentication, "CWE_308", "Use of Single-factor Authentication", "The use of single-factor authentication can lead to unnecessary risk of compromise when compared with the benefits of a dual-factor authentication scheme.");
		Weakness CWE_384 = new Weakness(Category.BrokenAuthentication, "CWE_384", "Session Fixation", "Authenticating a user, or otherwise establishing a new user session, without invalidating any existing session identifier gives an attacker the opportunity to steal authenticated sessions.");
		Weakness CWE_522 = new Weakness(Category.BrokenAuthentication, "CWE_522", "Insufficiently Protected Credentials", "This weakness occurs when the application transmits or stores authentication credentials and uses an insecure method that is susceptible to unauthorized interception and/or retrieval.");
		Weakness CWE_523 = new Weakness(Category.BrokenAuthentication, "CWE_523", "Unprotected Transport of Credentials", "Login pages not using adequate measures to protect the user name and password while they are in transit from the client to the server.");
		Weakness CWE_613 = new Weakness(Category.BrokenAuthentication, "CWE_613", "Insufficient Session Expiration", "According to WASC, Insufficient Session Expiration is when a web site permits an attacker to reuse old session credentials or session IDs for authorization.");
		Weakness CWE_620 = new Weakness(Category.BrokenAuthentication, "CWE_620", "Unverified Password Change", "When setting a new password for a user, the product does not require knowledge of the original password, or using another form of authentication.");
		Weakness CWE_640 = new Weakness(Category.BrokenAuthentication, "CWE_640", "Weak Password Recovery Mechanism for Forgotten Password", "The software contains a mechanism for users to recover or change their passwords without knowing the original password, but the mechanism is weak.");
		
		Weakness CWE_220 = new Weakness(Category.SensitiveDataExposure, "CWE_220", "Sensitive Data Under FTP Root", "The application stores sensitive data under the FTP document root with insufficient access control, which might make it accessible to untrusted parties.");
		Weakness CWE_295 = new Weakness(Category.SensitiveDataExposure, "CWE_295", "Improper Certificate Validation", "The software does not validate, or incorrectly validates, a certificate.");
		Weakness CWE_311 = new Weakness(Category.SensitiveDataExposure, "CWE_311", "Missing Encryption of Sensitive Data", "The software does not encrypt sensitive or critical information before storage or transmission.");
		Weakness CWE_312 = new Weakness(Category.SensitiveDataExposure, "CWE_312", "Cleartext Storage of Sensitive Information", "The application stores sensitive information in cleartext within a resource that might be accessible to another control sphere.");
		Weakness CWE_319 = new Weakness(Category.SensitiveDataExposure, "CWE_319", "Cleartext Transmission of Sensitive Information", "The software transmits sensitive or security-critical data in cleartext in a communication channel that can be sniffed by unauthorized actors.");
		Weakness CWE_325 = new Weakness(Category.SensitiveDataExposure, "CWE_325", "Missing Required Cryptographic Step", "The software does not implement a required step in a cryptographic algorithm, resulting in weaker encryption than advertised by that algorithm.");
		Weakness CWE_326 = new Weakness(Category.SensitiveDataExposure, "CWE_326", "Inadequate Encryption Strength", "The software stores or transmits sensitive data using an encryption scheme that is theoretically sound, but is not strong enough for the level of protection required.");
		Weakness CWE_327 = new Weakness(Category.SensitiveDataExposure, "CWE_327", "Use of a Broken or Risky Cryptographic Algorithm", "The use of a broken or risky cryptographic algorithm is an unnecessary risk that may result in the exposure of sensitive information.");
		Weakness CWE_328 = new Weakness(Category.SensitiveDataExposure, "CWE_328", "Reversible One-Way Hash", "The product uses a hashing algorithm that produces a hash value that can be used to determine the original input, or to find an input that can produce the same hash, more efficiently than brute force techniques.");
		Weakness CWE_359 = new Weakness(Category.SensitiveDataExposure, "CWE_359", "Exposure of Private Information ('Privacy Violation')", "The software does not properly prevent private data (such as credit card numbers) from being accessed by actors who either (1) are not explicitly authorized to access the data or (2) do not have the implicit consent of the people to which the data is related.");
		
		Weakness CWE_611 = new Weakness(Category.XMLExternalEntities, "CWE_611", "Improper Restriction of XML External Entity Reference", "The software processes an XML document that can contain XML entities with URIs that resolve to documents outside of the intended sphere of control, causing the product to embed incorrect documents into its output.");
		Weakness CWE_776 = new Weakness(Category.XMLExternalEntities, "CWE_776", "Improper Restriction of Recursive Entity References in DTDs ('XML Entity Expansion')", "The software uses XML documents and allows their structure to be defined with a Document Type Definition (DTD), but it does not properly control the number of recursive definitions of entities.");
		
		Weakness CWE_22 = new Weakness(Category.BrokenAccessControl, "CWE_22", "Improper Limitation of a Pathname to a Restricted Directory ('Path Traversal')", "The software uses external input to construct a pathname that is intended to identify a file or directory that is located underneath a restricted parent directory, but the software does not properly neutralize special elements within the pathname that can cause the pathname to resolve to a location that is outside of the restricted directory.");
		Weakness CWE_284 = new Weakness(Category.BrokenAccessControl, "CWE_284", "Improper Access Control", "The software does not restrict or incorrectly restricts access to a resource from an unauthorized actor.");
		Weakness CWE_285 = new Weakness(Category.BrokenAccessControl, "CWE_285", "Improper Authorization", "The software does not perform or incorrectly performs an authorization check when an actor attempts to access a resource or perform an action.");
		Weakness CWE_425 = new Weakness(Category.BrokenAccessControl, "CWE_425", "Direct Request ('Forced Browsing')", "The web application does not adequately enforce appropriate authorization on all restricted URLs, scripts, or files.");
		Weakness CWE_639 = new Weakness(Category.BrokenAccessControl, "CWE_639", "Authorization Bypass Through User-Controlled Key", "The system's authorization functionality does not prevent one user from gaining access to another user's data or record by modifying the key value identifying the data.");
		
		Weakness CWE_209 = new Weakness(Category.SecurityMisconfiguration, "CWE_209", "Information Exposure Through an Error Message", "The software generates an error message that includes sensitive information about its environment, users, or associated data.");
		Weakness CWE_548 = new Weakness(Category.SecurityMisconfiguration, "CWE_549", "Information Exposure Through Directory Listing", "A directory listing is inappropriately exposed, yielding potentially sensitive information to attackers.");
		
		Weakness CWE_79 = new Weakness(Category.XSS, "CWE_79", "Improper Neutralization of Input During Web Page Generation ('Cross-site Scripting')", "The software does not neutralize or incorrectly neutralizes user-controllable input before it is placed in output that is used as a web page that is served to other users.");
		
		Weakness CWE_502 = new Weakness(Category.InsecureDeserialization, "CWE_502", "Deserialization of Untrusted Data", "The application deserializes untrusted data without sufficiently verifying that the resulting data will be valid.");
		
		Weakness CWE_223 = new Weakness(Category.InsufficientLoggingMonitoring, "CWE_223", "Omission of Security-relevant Information", "The application does not record or display information that would be important for identifying the source or nature of an attack, or determining if an action is safe.");
		Weakness CWE_778 = new Weakness(Category.InsufficientLoggingMonitoring, "CWE_778", "Insufficient Logging", "When a security-critical event occurs, the software either does not record the event or omits important details about the event when logging it.");
		
		map.put("CWE_77", CWE_77);
		map.put("CWE_78", CWE_78);
		map.put("CWE_88", CWE_88);
		map.put("CWE_89", CWE_89);
		map.put("CWE_90", CWE_90);
		map.put("CWE_91", CWE_91);
		map.put("CWE_564", CWE_564);
		map.put("CWE_917", CWE_917);
		map.put("CWE_943", CWE_943);
		map.put("CWE_256", CWE_256);
		map.put("CWE_287", CWE_287);
		map.put("CWE_308", CWE_308);
		map.put("CWE_384", CWE_384);
		map.put("CWE_522", CWE_522);
		map.put("CWE_523", CWE_523);
		map.put("CWE_613", CWE_613);
		map.put("CWE_620", CWE_620);
		map.put("CWE_640", CWE_640);
		map.put("CWE_220", CWE_220);
		map.put("CWE_295", CWE_295);
		map.put("CWE_311", CWE_311);
		map.put("CWE_312", CWE_312);
		map.put("CWE_319", CWE_319);
		map.put("CWE_325", CWE_325);
		map.put("CWE_326", CWE_326);
		map.put("CWE_327", CWE_327);
		map.put("CWE_328", CWE_328);
		map.put("CWE_359", CWE_359);
		map.put("CWE_611", CWE_611);
		map.put("CWE_776", CWE_776);
		map.put("CWE_22", CWE_22);
		map.put("CWE_284", CWE_284);
		map.put("CWE_285", CWE_285);
		map.put("CWE_425", CWE_425);
		map.put("CWE_639", CWE_639);
		map.put("CWE_209", CWE_209);
		map.put("CWE_548", CWE_548);
		map.put("CWE_79", CWE_79);
		map.put("CWE_502", CWE_502);
		map.put("CWE_223", CWE_223);
		map.put("CWE_778", CWE_778);
	}
	
	public Weakness get(String CWE_ID) {
		return map.get(CWE_ID);
	}
	
	public Map<String, Weakness> getWeaknessMap(){
		return this.map;
	}
}
