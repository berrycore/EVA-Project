package berry.eva.evaluation.scan;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import berry.eva.evaluation.Category;
import berry.eva.evaluation.Result;

public class HTTPMethodScan extends AbstractScan {

	@Override
	public Result execute(String url) {

		try {
			Response response = Jsoup.connect(url).userAgent("EVA-Project").method(Method.HEAD).execute();
			Map<String, String> headers = response.headers();
			System.out.println(headers.toString());
			if(response.statusCode() == HttpURLConnection.HTTP_OK) {
				System.out.println("head !");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		//TODO : definition required
	}

}
