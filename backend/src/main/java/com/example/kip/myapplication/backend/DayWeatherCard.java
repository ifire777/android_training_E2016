package com.example.kip.myapplication.backend;

import javax.inject.Named;

public class DayWeatherCard {
	@Named
	private String weatherType;
	@Named
	private String tempC;
	@Named
	private String humidity;
	@Named
	private String windSpeed;

	public String getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getTempC() {
		return tempC;
	}

	public void setTempC(String tempC) {
		this.tempC = tempC;
	}

	public String getWeatherType() {
		return weatherType;
	}

	public void setWeatherType(String weatherType) {
		this.weatherType = weatherType;
	}


}