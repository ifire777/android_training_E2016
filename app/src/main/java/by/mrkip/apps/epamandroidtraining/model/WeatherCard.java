package by.mrkip.apps.epamandroidtraining.model;


public class WeatherCard {

	private String weatherType;
	private String tempC;
	private String humidity;
	private String windSpeed;
	private String date;
	private String imageURL;

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

		this.tempC = tempC;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity =  humidity;
	}

	public String getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(String windSpeed) {
		this.windSpeed =  windSpeed ;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}


}
