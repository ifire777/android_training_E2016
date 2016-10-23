package by.mrkip.apps.epamandroidtraining.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kip on 14.10.2016.
 */

public class DayCard {
	private String weatherType;
	private String tempC;
	private String humidity;
	private String windSpeed;
	private String date;


	public DayCard(JSONObject jsonObj) throws JSONException {
		this.setTempC(jsonObj.getString("temp_C"));
		this.setWeatherType(jsonObj.getJSONArray("weatherDesc").getJSONObject(0).getString("value"));
		this.setHumidity(jsonObj.getString("humidity"));
		this.setWindSpeed(String.valueOf(Math.round((jsonObj.getDouble("windspeedKmph") / 3.6) * 10d) / 10d));

	}

	public DayCard(String weatherType, String tempC, String humidity, String windSpeed) {
		this.setWeatherType(weatherType);
		this.setTempC(tempC);
		this.setHumidity(humidity);
		this.setWindSpeed(windSpeed);
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWeatherType() {
		return weatherType;
	}

	public void setWeatherType(String weatherType) {
		this.weatherType = weatherType;
	}

	public String getTempC() {
		return tempC;
	}

	public void setTempC(String tempC) {
		this.tempC = tempC + "C";
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = "humidity: " + humidity + "%";
	}

	public String getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(String windSpeed) {
		this.windSpeed = "wind: " + windSpeed + "m/s";
	}


}
