package by.mrkip.apps.epamandroidtraining.model;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Make new class-presenter with implementing  <tt>ResultConverter<Result></tt> interface
 * to get ready <tt><Result></tt> object from <tt>httpClient</tt> request
 */
@Deprecated
public class WeatherCardFiller {


	private static final String TEMP_C1 = "tempC";
	private static final String TEMP_C = "temp_C";
	private static final String WEATHER_DESC = "weatherDesc";
	private static final String HUMIDITY = "humidity";
	private static final String WINDSPEED_KMPH = "windspeedKmph";

	private static final String KEY_VALUE = "value";


	public WeatherCardFiller() {

	}

	public WeatherCard fillFutureWeatherFromJson(JSONObject jsonObj, WeatherCard weatherCard) throws JSONException {
		weatherCard.setTempC(jsonObj.getString(TEMP_C));
		weatherCard.setWeatherType(jsonObj.getJSONArray(WEATHER_DESC).getJSONObject(0).getString(KEY_VALUE));
		weatherCard.setHumidity(jsonObj.getString(HUMIDITY));
		weatherCard.setWindSpeed(String.valueOf(Math.round((jsonObj.getDouble(WINDSPEED_KMPH) / 3.6) * 10d) / 10d));

		return weatherCard;
	}

	public WeatherCard fillPastWeatherFromJson(JSONObject jsonObj, WeatherCard weatherCard) throws JSONException {
		weatherCard.setTempC(jsonObj.getString(TEMP_C1));
		weatherCard.setWeatherType(jsonObj.getJSONArray(WEATHER_DESC).getJSONObject(0).getString(KEY_VALUE));
		weatherCard.setHumidity(jsonObj.getString(HUMIDITY));
		weatherCard.setWindSpeed(String.valueOf(Math.round((jsonObj.getDouble(WINDSPEED_KMPH) / 3.6) * 10d) / 10d));

		return weatherCard;
	}
}
