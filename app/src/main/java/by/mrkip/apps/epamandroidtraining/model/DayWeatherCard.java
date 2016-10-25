package by.mrkip.apps.epamandroidtraining.model;

import org.json.JSONException;
import org.json.JSONObject;


public class DayWeatherCard extends WeatherCard {

	public static final String TEMP_C = "temp_C";
	public static final String WEATHER_DESC = "weatherDesc";
	public static final String HUMIDITY = "humidity";
	public static final String WINDSPEED_KMPH = "windspeedKmph";


	public static final String KEY_VALUE = "value";

	public DayWeatherCard(String weatherType, String tempC, String humidity, String windSpeed) {
		super(weatherType, tempC, humidity, windSpeed);
	}

	public DayWeatherCard() {
		super();
	}

	public DayWeatherCard fillFutureWeatherFromJson(JSONObject jsonObj) throws JSONException {
		this.setTempC(jsonObj.getString(TEMP_C));
		this.setWeatherType(jsonObj.getJSONArray(WEATHER_DESC).getJSONObject(0).getString(KEY_VALUE));
		this.setHumidity(jsonObj.getString(HUMIDITY));
		this.setWindSpeed(String.valueOf(Math.round((jsonObj.getDouble(WINDSPEED_KMPH) / 3.6) * 10d) / 10d));

		return this;
	}

	public DayWeatherCard fillPastWeatherFromJson(JSONObject jsonObj) throws JSONException {
		this.setTempC(jsonObj.getString(TEMP_C));
		this.setWeatherType(jsonObj.getJSONArray(WEATHER_DESC).getJSONObject(0).getString(KEY_VALUE));
		this.setHumidity(jsonObj.getString(HUMIDITY));
		this.setWindSpeed(String.valueOf(Math.round((jsonObj.getDouble(WINDSPEED_KMPH) / 3.6) * 10d) / 10d));

		return this;
	}
}
