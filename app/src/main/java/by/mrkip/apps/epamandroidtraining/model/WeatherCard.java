package by.mrkip.apps.epamandroidtraining.model;


import android.content.Context;

import by.mrkip.apps.epamandroidtraining.R;
import by.mrkip.apps.epamandroidtraining.util.ContextHolder;

public class WeatherCard {

	private String weatherType;
	private String tempC;
	private String humidity;
	private String windSpeed;
	private String date;
	private Context context= ContextHolder.getInstance().getContext();

	public WeatherCard() {
	}

	public WeatherCard(String weatherType, String tempC, String humidity, String windSpeed) {
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

		this.tempC = tempC + context.getString(R.string.wc_C);
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = context.getString(R.string.wc_humidity) + humidity + context.getString(R.string.wc_persent);
	}

	public String getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(String windSpeed) {
		this.windSpeed = context.getString(R.string.wc_wind) + windSpeed + context.getString(R.string.wc_speed_units);
	}


}
