package berry.eva.core;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Crawler {
	
	private static Crawler instance = new Crawler();
	
	private Crawler() {	}
	
	public static Crawler getInstance() {
		return instance;
	}

	private List<Context> list_context = new ArrayList<Context>();
	
	private void sendGet(String targetUrl) throws IOException {
		URL url = new URL(targetUrl);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "EVA-Project");
		
		int responseCode = con.getResponseCode();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		
		
		while((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		// print result
		System.out.println("HTTP responseCode : " + responseCode );
		System.out.println("HTTP body : " + response.toString());
	}
	
	private void sendPost(String targetUrl, String parameters) throws IOException {
		
		URL url = new URL(targetUrl);
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "EVA-project");
		
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(parameters);
		wr.flush();
		wr.close();
		
		int responseCode = con.getResponseCode();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		
		while((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		System.out.println("HTTP responseCode : " + responseCode);
		System.out.println("HTTP body : " + response.toString());
	}
}
