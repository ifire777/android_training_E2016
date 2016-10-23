package by.mrkip.apps.epamandroidtraining.model.dayCardRequestModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RootData {
	@SerializedName("request")
	private List<Request> requestJA;


	@SerializedName("weather")
	private List<Weather> weatherJA;


	public List<Weather> getWeatherJA() {
		return weatherJA;
	}

	public List<Request> getRequestJA() {
		return requestJA;
	}
}
