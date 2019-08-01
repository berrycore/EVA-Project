package berry.eva.core;

public class Status {

	// 1. Searching
	public static enum Searching {
		ON, OFF
	}

	private static Searching searchingStatus = Searching.OFF;

	public static boolean isSearching() {
		if (searchingStatus.equals(Searching.ON)) {
			return true;
		} else {
			return false;
		}
	}

	public static void setStatus(Searching status) {
		searchingStatus = status;
	}
	
	
	// 2. Scanning
	public static enum Scanning {
		ON, OFF
	}
	
	private static Scanning scanningStatus = Scanning.OFF;
	
	public static boolean isScanning() {
		if(scanningStatus.equals(Scanning.ON)) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void setStatus(Scanning status) {
		scanningStatus = status;
	}
	
	public static int TASK_COUNT = 0;
}
