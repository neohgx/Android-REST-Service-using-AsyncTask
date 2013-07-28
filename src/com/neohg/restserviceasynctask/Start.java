package com.neohg.restserviceasynctask;

import org.json.JSONException;
import org.json.JSONObject;

import com.neohg.restserviceasynctask.RestClient.RequestMethod;

public class Start {
	public static String UnixTimeStampToDateTime(String unixTimeStamp) {

		long tiemstamp = Long.parseLong(unixTimeStamp);
		String dateStr = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date (tiemstamp*1000));

		return dateStr;
	}

	public static String parseJSONResponse(String jsonResponse) {
		String timestamp = "";

		JSONObject json;
		try {
			json = new JSONObject(jsonResponse);
			JSONObject result = json.getJSONObject("Result");
			timestamp = result.getString("Timestamp");

		} catch (JSONException e) {

			e.printStackTrace();
		}

		return timestamp;
	}

	public static String getTimeStampFromYahooService() {

		String responseString = null;

		String baseurlString = "http://developer.yahooapis.com/TimeService/V1/getTime";

		RestClient client = new RestClient(baseurlString);
		client.AddParam("appid", "YahooDemo");
		client.AddParam("output", "json");

		try {
			client.Execute(RequestMethod.GET);
		} catch (Exception e) {
			e.printStackTrace();
		}

		responseString = client.getResponse();

		return responseString;
	}
}
