package by.mrkip.apps.epamandroidtraining.presenters.PresenterHelper;

import android.os.Handler;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import by.mrkip.apps.epamandroidtraining.model.DayWeatherCard;
import by.mrkip.apps.epamandroidtraining.model.HttpRequestModel;
import by.mrkip.libs.http.HttpClient;

import static android.content.ContentValues.TAG;

public class LoadJSON implements Runnable {
	private final Handler myHandler;
	private String mUrl;

	public LoadJSON(Handler myHandler, String mUrl) {
		this.myHandler = myHandler;
		this.mUrl = mUrl;
	}


	@Override
	public void run() {
		HttpRequestModel httpGet = new HttpRequestModel();
		HttpClient httpClient = new HttpClient();
		try {

			httpGet.setUrl(mUrl);

			String responseStr = httpClient.get(httpGet.getUrl());

			JSONObject dayCardJSONObj = new JSONObject(responseStr)
					.getJSONObject("data")
					.getJSONArray("current_condition")
					.getJSONObject(0);

			DayWeatherCard respObject = new DayWeatherCard().fillFutureWeatherFromJson(dayCardJSONObj);
			myHandler.post(new Runnable() {
				@Override
				public void run() {

				}
			});

		} catch (IOException | JSONException e) {
			Log.e(TAG, this.toString() + ":", e);

		} catch (Exception e) {
			Log.e(TAG, this.toString() + ":", e);

		}
	}
}
