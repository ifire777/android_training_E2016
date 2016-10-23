package by.mrkip.apps.epamandroidtraining.model.dayCardRequestModel;

import com.google.gson.annotations.SerializedName;

public class Hourly {
	@SerializedName("tempC")
	private Integer tempC;

	@SerializedName("windspeedKmph")
	private Integer windspeedKmph;

	@SerializedName("humidity")
	private Integer humidity;

	public Integer getTempC() {
		return tempC;
	}

	public Integer getWindspeedKmph() {
		return windspeedKmph;
	}

	public Integer getHumidity() {
		return humidity;
	}
}
