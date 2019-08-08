package berry.eva.evaluation.scan;

import java.io.IOError;
import java.io.IOException;

import org.apache.http.HttpStatus;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Request;
import org.jsoup.Connection.Response;

import berry.eva.application.R;
import berry.eva.core.Context;
import berry.eva.core.SearchEngine;

public class ScanWEBINF extends AbstractScan{

	@Override
	public Context execute(String url) {

		Context context = new Context();
		String startTime = getCurrentTime();
		
		try {
			String root = SearchEngine.getInstance().getRoot();
			
			Connection connection = Jsoup.connect(root + "/WEB-INF/web.xml").userAgent(R.EVA_PROJECT).method(Method.GET);
			
			Request request = connection.request();
			Response response = connection.execute();
			String elapsedTime = getCurrentTime();
			
			String req_body = request.requestBody() == null ? "" : request.requestBody();
			String resp_body = response.body() == null ? "" : response.body();
			
			System.out.println(response.headers());
			
			context.setURL(url)
				.setMethod(Method.GET.toString())
				.setReq_Timestamp(startTime)
				.setReq_Header(request.headers())
				.setReq_Body(req_body)
				.setResp_Timestamp(elapsedTime)
				.setResp_Code(Integer.toString(response.statusCode()))
				.setResp_Reason(response.statusMessage())
				.setResp_Headers(response.headers())
				.setResp_Body(resp_body)
				.setCWE_ID("CWE_549");
			if(response.statusCode() == HttpStatus.SC_OK) {
				context.setVulnerable(true);
			}else {
				context.setVulnerable(false);
			}
			
		}catch(HttpStatusException ce) {
			context.setURL(ce.getUrl());
			context.setMethod(Method.GET.toString());
			context.setReq_Timestamp(startTime);
			context.setResp_Timestamp(getCurrentTime());
			context.setResp_Code(ce.getStatusCode()+"");
			context.setResp_Reason(org.apache.commons.httpclient.HttpStatus.getStatusText(ce.getStatusCode()));
			context.setCWE_ID(R.TEXT.UN_KNOWN);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return context;
	}

	
}
