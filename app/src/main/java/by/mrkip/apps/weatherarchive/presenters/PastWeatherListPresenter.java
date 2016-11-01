package by.mrkip.apps.weatherarchive.presenters;


import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import by.mrkip.apps.weatherarchive.R;
import by.mrkip.apps.weatherarchive.globalObj.AppContextIns;
import by.mrkip.apps.weatherarchive.model.WeatherCard;
import by.mrkip.libs.http.HttpClient;

public class PastWeatherListPresenter implements HttpClient.ResultConverter<List<WeatherCard>> {

	private static final String TEMP_C1 = "tempC";
	private static final String WEATHER_DESC = "weatherDesc";
	private static final String HUMIDITY = "humidity";
	private static final String WINDSPEED_KMPH = "windspeedKmph";
	private static final String WEATHER_ICON_URL = "weatherIconUrl";


	private static final String VALUE_DATA = "data";
	private static final String VALUE_WEATHER = "weather";
	private static final String VALUE_HOURLY = "hourly";
	public static final String KEY_VALUE = "value";

	private final Context context = AppContextIns.get();


	@Override
	public List<WeatherCard> convert(InputStream inputStream) {
		List<WeatherCard> res = new ArrayList<WeatherCard>();

		JSONArray records = null;
		try {
			records = new JSONObject(getJSONString(inputStream))
					.getJSONObject(VALUE_DATA)
					.getJSONArray(VALUE_WEATHER);

			for (int i = 0; i < records.length(); i++) {
				WeatherCard respObject = new WeatherCard();
				res.add(fillPastWeatherFromJson(records.getJSONObject(i).getJSONArray(VALUE_HOURLY).getJSONObject(0), respObject));
			}
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}

		return res;

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

	public WeatherCard fillPastWeatherFromJson(JSONObject jsonObj, WeatherCard weatherCard) throws JSONException {
		weatherCard.setTempC(jsonObj.getString(TEMP_C1) + context.getString(R.string.wc_C));
		weatherCard.setWeatherType(jsonObj.getJSONArray(WEATHER_DESC).getJSONObject(0).getString(KEY_VALUE));
		weatherCard.setHumidity(context.getString(R.string.wc_humidity) + jsonObj.getString(HUMIDITY) + context.getString(R.string.wc_persent));
		weatherCard.setWindSpeed(context.getString(R.string.wc_wind) + String.valueOf(Math.round((jsonObj.getDouble(WINDSPEED_KMPH) / 3.6) * 10d) / 10d) + context.getString(R.string.wc_speed_units));
		weatherCard.setImageURL(jsonObj.getJSONArray(WEATHER_ICON_URL).getJSONObject(0).getString(KEY_VALUE));

		return weatherCard;
	}


}
