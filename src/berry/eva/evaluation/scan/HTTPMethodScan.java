package berry.eva.evaluation.scan;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Request;
import org.jsoup.Connection.Response;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;

import berry.eva.application.R;
import berry.eva.core.Context;

public class HTTPMethodScan extends AbstractScan {

	@Override
	public Context execute(String url) {
		
		Context context = new Context();
		String startTime = getCurrentTime();
		try {
			
			Connection connection = Jsoup.connect(url).userAgent(R.EVA_PROJECT).method(Method.PUT);
			Request request = connection.request();
			Response response = connection.execute();			
			
			String elapsedTime = getCurrentTime();
			
			context.setURL(url)
					.setMethod(Method.PUT.toString())
					.setReq_Timestamp(startTime)
					.setReq_Header(request.headers())
					.setReq_Body(request.requestBody())
					.setResp_Timestamp(elapsedTime)
					.setResp_Code(Integer.toString(response.statusCode()))
					.setResp_Reason(response.statusMessage())
					.setResp_Headers(response.multiHeaders())
					.setCWE_ID("CWE_650");
			if(response.statusCode() == 200) {
				context.setVulnerable(true);
			}else {
				context.setVulnerable(false);
			}
		} catch (HttpStatusException ce) {
			context.setURL(ce.getUrl());
			context.setReq_Timestamp(startTime);
			context.setResp_Timestamp(getCurrentTime());
			context.setResp_Code(ce.getStatusCode()+"");
			context.setResp_Reason(ce.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return context;
	}
}
