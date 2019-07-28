package berry.eva.evaluation.scan;

import java.text.SimpleDateFormat;
import java.util.Date;

import berry.eva.evaluation.Vulnerable;

public abstract class AbstractScan implements Vulnerable{

	protected String getCurrentTime() {
		long time = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		return dayTime.format(new Date(time));
	}
}
