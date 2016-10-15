/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.kip.myapplication.backend;


import com.example.kip.myapplication.backend.utilObjects.urlGETStrBuilder;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;

import org.json.JSONException;
import org.json.JSONObject;

import by.mrkip.libs.http.HttpClient;

/**
 * An endpoint class we are exposing
 */
@Api(
		name = "myApi",
		version = "v1",
		namespace = @ApiNamespace(
				ownerDomain = "weather.backend.mrkip.by",
				ownerName = "weather.backend.mrkip.by",
				packagePath = ""
		)
)
public class MyEndpoint {
	public static final String WEATHER_URL = "http://api.worldweatheronline.com/free/v2/past-weather.ashx";

	@ApiMethod(name = "sayHi")
	public MyBean sayHi(@Named("name") String name) {
		MyBean response = new MyBean();
		response.setData("Hi, " + name);

		return response;
	}

	@ApiMethod(name = "getDayWeather")
	public DayWeatherCard getDayWeather(@Named("coorX") String coorLan, @Named("coorY") String coorLon) {
		JSONObject jObj = null;

		DayWeatherCard response = new DayWeatherCard();
String getUrl=new urlGETStrBuilder(WEATHER_URL)
		.addParam("q",coorLan+","+coorLon)
		.addParam("format","json")
		.addParam("date","today")
		.addParam("includelocation","yes")
		.addParam("key","de2eebb1950884eb9e557aaf3197f")
		.addParam("tp","24")
		.getUrl();
		String data = new HttpClient().get(getUrl);


		try {
			jObj = new JSONObject(data);


		//JSONArray product = jObj.getJSONArray("weather");
		JSONObject dayWeatherInfo = jObj.getJSONObject("data").getJSONArray("weather").getJSONObject(0).getJSONArray("hourly").getJSONObject(0);


		response.setTempC(dayWeatherInfo.getString("tempC")+"C");
		response.setWeatherType(dayWeatherInfo.getJSONArray("weatherDesc").getJSONObject(0).getString("value"));
		response.setHumidity("humidity: "+dayWeatherInfo.getString("humidity")+"%");
		response.setWindSpeed("wind: "+String.valueOf(Math.round((dayWeatherInfo.getDouble("windspeedKmph")/3.6)*10d)/10d)+"m/s");

		} catch (JSONException e) {
			System.out.print(e.toString());
		}
		return response;
	}


}
