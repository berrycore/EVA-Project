package berry.eva.evaluation.scan;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.httpclient.HttpStatus;
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
			
			String req_body = request.requestBody() == null ? "" : request.requestBody();
			String resp_body = response.body() == null ? "" : response.body();
			
			
			System.out.println(response.headers());
			
			context.setURL(url)
					.setMethod(Method.PUT.toString())
					.setReq_Timestamp(startTime)
					.setReq_Header(request.headers())
					.setReq_Body(req_body)
					.setResp_Timestamp(elapsedTime)
					.setResp_Code(Integer.toString(response.statusCode()))
					.setResp_Reason(response.statusMessage())
					.setResp_Headers(response.headers())
					.setResp_Body(resp_body)
					.setCWE_ID("CWE_650");
			if(response.statusCode() == 200) {
				context.setVulnerable(true);
			}else {
				context.setVulnerable(false);
			}
		} catch (HttpStatusException ce) {
			context.setURL(ce.getUrl());
			context.setMethod(Method.PUT.toString());
			context.setReq_Timestamp(startTime);
			context.setResp_Timestamp(getCurrentTime());
			context.setResp_Code(ce.getStatusCode()+"");
			//context.setResp_Reason(ce.toString());
			context.setResp_Reason(HttpStatus.getStatusText(ce.getStatusCode()));
			context.setCWE_ID(R.TEXT.UN_KNOWN);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return context;
	}
}
