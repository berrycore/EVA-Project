package berry.eva.project;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Project {

	private String name;
	private String createdtime;

	public Project(String name) {
		this.name = name;
		this.createdtime = getCurrentTime();
	}

	public String getName() {
		return this.name;
	}

	public String getCreatedTime() {
		return this.createdtime;
	}

	private String getCurrentTime() {
		long time = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		return dayTime.format(new Date(time));
	}
}
