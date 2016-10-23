package by.mrkip.apps.epamandroidtraining.model.dayCardRequestModel;

import com.google.gson.annotations.SerializedName;

public class RootDataJO {
	@SerializedName("data")
	private RootData data;

	public RootData getData() {
		return data;
	}

	public void setData(RootData data) {
		this.data = data;
	}
}
