package by.mrkip.apps.weatherarchive.presenters;


import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import by.mrkip.libs.http.HttpClient;

import static by.mrkip.apps.weatherarchive.globalObj.JsonKeys.VALUE_ERROR_MESSAGE;
import static by.mrkip.apps.weatherarchive.globalObj.JsonKeys.VALUE_STATUS;

public class CityDataPresenter implements HttpClient.ResultConverter<String> {

	public static final String OK = "OK";


	@Override
	public String convert(InputStream inputStream) {
		String result = null;


		try {
			JSONObject jsonObj = new JSONObject(getJSONString(inputStream));

			if (jsonObj.getString(VALUE_STATUS).equals(OK)) {
				jsonObj = jsonObj.getJSONObject("result").getJSONObject("geometry").getJSONObject("location");
				result = jsonObj.getString("lat").concat(",").concat(jsonObj.getString("lng"));

			} else {

				Log.e(this.toString(), "BAD JSON RESULT:" + jsonObj.getString(VALUE_ERROR_MESSAGE));
			}
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	private String getJSONString(InputStream inputStream) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		StringBuilder stringBuilder = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line);
		}
		return stringBuilder.toString();

	}
}
