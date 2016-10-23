package by.mrkip.apps.epamandroidtraining.model.dayCardRequestModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Weather {

	@SerializedName("date" )
	private UFDate castomDate;

	@SerializedName("hourly")
	private List<Hourly> hourlyJA;

	public UFDate getCastomDate() {
		return castomDate;
	}

	public List<Hourly> getHourlyJA() {
		return hourlyJA;
	}
}
