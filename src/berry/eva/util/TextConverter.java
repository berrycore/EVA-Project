package berry.eva.util;

import java.util.Map;
import java.util.Set;

public final class TextConverter {

	public static String MapToString(Map<String, String> map) {
		StringBuffer buffer = new StringBuffer();
		
		Set<String> keys = map.keySet();
		for(String key : keys) {
			buffer.append(key).append('=').append(map.get(key)).append('\n');
		}
		
		return buffer.toString();
	}

	
	public static String IntToAvailable(Integer i) {
		return (i==1)? "Available" : "NotAvailable";
	}
}
