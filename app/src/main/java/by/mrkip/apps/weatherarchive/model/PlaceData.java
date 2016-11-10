package by.mrkip.apps.weatherarchive.model;



public class PlaceData {

	private String placeName;
	private String placeId;
	private String lan;
	private String lon;


	public PlaceData(String placeName, String placeId) {
		this.placeName = placeName;
		this.placeId = placeId;
	}

	public String getLan() {
		return lan;
	}

	public void setLan(String lan) {
		this.lan = lan;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
}
