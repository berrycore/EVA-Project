package berry.eva.evaluation;

import berry.eva.evaluation.scan.ScanMethodPUT;
import berry.eva.evaluation.scan.ScanWEBINF;

public class VulnerableFactory {
	
	public Vulnerable generate(String cwe_id) {
		if(cwe_id.equals("CWE_650")) {
			return new ScanMethodPUT();
		}else if(cwe_id.equals("CWE_549")) {
			return new ScanWEBINF();
		}else {
			return null;
		}
	}
}
