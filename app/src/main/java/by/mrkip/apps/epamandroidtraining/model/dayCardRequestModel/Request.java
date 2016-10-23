package by.mrkip.apps.epamandroidtraining.model.dayCardRequestModel;


import com.google.gson.annotations.SerializedName;

public class Request {
	@SerializedName("type")
	private String type;

	@SerializedName("query")
	private String query;

	public String getType() {
		return type;
	}

	public String getQuery() {
		return query;
	}
}
