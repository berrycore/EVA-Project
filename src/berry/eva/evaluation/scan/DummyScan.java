package berry.eva.evaluation.scan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import berry.eva.core.Context;
import berry.eva.evaluation.Category;
import berry.eva.evaluation.Result;

public final class DummyScan extends AbstractScan {

	@Override
	public Result execute(String url)  {

		Context context = new Context();
		URL Url;
		try {
			Url = new URL(url);
			HttpURLConnection con = (HttpURLConnection) Url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "EVA-Project");
			int responseCode = con.getResponseCode();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println("HTTP 응답 코드 : " + responseCode);
			System.out.println("HTTP body : " + response.toString());
			
			context.setResp_Body(response.toString());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		return new Result(Category.SecurityMisconfiguration, "DefaultScan", "description");
	}
}
