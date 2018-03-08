package edu.unh.cs980.methods;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

public class SpotClient {
	static String spotlightAPIurl = "http://model.dbpedia-spotlight.org/en/annotate?";

	public static String getAnootatedJson(String text, float confidence) throws Exception {
		// Remove spaces.
		String httpUrl = spotlightAPIurl + "text=" + text.replace(" ", "%20") + "&confidence=";
		String responseStr = sendGet(httpUrl);

		// Remove "@" in key of json string
		responseStr = responseStr.replace("\"@", "\"");
		// System.out.println(responseStr);

		return responseStr;
	}

	private static String sendGet(String url) throws Exception {
		StringBuffer result = new StringBuffer();

		try {
			HttpClient client = HttpClients.createDefault();

			HttpGet request = new HttpGet(url);

			request.addHeader("Accept", "application/json");

			HttpResponse response = client.execute(request);

			System.out.println(url);
			System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			System.out.println(response.toString());
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			System.out.println(result.length());

			System.out.println(result.toString());
		} catch (Exception e) {
			System.out.println("Can't get response from SpotLight API.");
		}

		return result.toString();
	}
}
