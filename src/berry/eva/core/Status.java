package berry.eva.core;

public class Status {

	public static enum Searching {
		ON, OFF
	}

	private static Searching currentStatus = Searching.OFF;

	public static boolean isSearching() {
		if (currentStatus.equals(Searching.ON)) {
			return true;
		} else {
			return false;
		}
	}

	public static void setStatus(Searching status) {
		currentStatus = status;
	}
}
