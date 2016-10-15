package by.mrkip.apps.epamandroidtraining.model;

/**
 * Created by kip on 14.10.2016.
 */

public class DayCard {
	private String weatherType;
	private String tempC;
	private String humidity;
	private String windSpeed;

	public DayCard(String weatherType, String tempC, String humidity, String windSpeed) {
		this.setWeatherType(weatherType);
		this.setTempC(tempC);
		this.setHumidity(humidity);
		this.setWindSpeed(windSpeed);
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
		this.tempC = tempC;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}



}
