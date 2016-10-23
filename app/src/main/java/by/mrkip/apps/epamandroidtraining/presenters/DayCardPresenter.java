package by.mrkip.apps.epamandroidtraining.presenters;


import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import by.mrkip.apps.epamandroidtraining.ApiManager;
import by.mrkip.apps.epamandroidtraining.contracts.IDayCardContract;
import by.mrkip.apps.epamandroidtraining.dataCasting.DateCast;
import by.mrkip.apps.epamandroidtraining.model.DayCard;
import by.mrkip.apps.epamandroidtraining.model.HttpRequestModel;
import by.mrkip.apps.epamandroidtraining.model.dayCardRequestModel.RootDataJO;
import by.mrkip.apps.epamandroidtraining.model.dayCardRequestModel.UFDate;
import by.mrkip.backend.weather.myApi.MyApi;
import by.mrkip.backend.weather.myApi.model.DayWeatherCard;
import by.mrkip.libs.http.HttpClient;
import by.mrkip.libs.http.httpUtils.urlGETStrBuilder;

import static android.content.ContentValues.TAG;

/**
 * Created by kip on 13.10.2016.
 */

public class DayCardPresenter implements IDayCardContract.Presenter {
	public static final String WEATHER_URL = "http://api.worldweatheronline.com/free/v2/weather.ashx";
	public static final String WEATHER_API_KEY = "de2eebb1950884eb9e557aaf3197f";


	private IDayCardContract.DayCardView view;
	private Handler handler;

	public DayCardPresenter(@NonNull IDayCardContract.DayCardView view) {
		this.view = view;
		handler = new Handler(Looper.getMainLooper());
	}

	@Override
	public void onReady() {
		view.showProgress(true);
		//loadDataFromSelfBackend();
		loadDayCardData("53.6667", "23.8333", "2016-10-23");
	}

	private void loadDayCardData(final String coorLan, final String coorLon, final String dt) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				HttpRequestModel httpGet = new HttpRequestModel();
				HttpClient httpClient = new HttpClient();
				try {
					String getUrl = new urlGETStrBuilder(WEATHER_URL)
							.addParam("q", coorLan + "," + coorLon)
							.addParam("format", "json")
							.addParam("date", dt)
							.addParam("includelocation", "yes")
							.addParam("key", WEATHER_API_KEY)
							.addParam("tp", "24")
							.getUrl();

					httpGet.setUrl(getUrl);

					String responseStr = httpClient.get(httpGet.getUrl());

					//TODO: Do I need to implement full chain of json objects/arrays in data model or this way is OK?
					JSONObject dayCardJSONObj = new JSONObject(responseStr)
							.getJSONObject("data")
							.getJSONArray("current_condition")
							.getJSONObject(0);
					DayCard respObject = new DayCard(dayCardJSONObj);


					Gson gson = new GsonBuilder().registerTypeAdapter(UFDate.class, new DateCast()).create();
					RootDataJO dayCardByGson = gson.fromJson(responseStr, RootDataJO.class);
					//fill some response Object fild from Gson-way parsed object
					respObject.setDate(dayCardByGson.getData().getWeatherJA().get(0).getCastomDate().getUfDate());

					notifyResponse(respObject);

				} catch (IOException e) {
					Log.e(TAG, this.toString() + ":", e);
					notifyError(e);
				} catch (JSONException e) {
					Log.e(TAG, this.toString() + ":", e);
					notifyError(e);
				} catch (Exception e) {
					Log.e(TAG, this.toString() + ":", e);
					notifyError(e);
				}
			}
		}).start();
	}

	private void loadDataFromSelfBackend() {

		new Thread(new Runnable() {
			@Override
			public void run() {

				try {
					MyApi.GetDayWeather call = ApiManager.get().trainingsApi().getDayWeather("53.6667", "23.8333");
					DayWeatherCard bean;
					bean = call.execute();
					DayCard response = new DayCard(bean.getWeatherType(), bean.getTempC(), bean.getHumidity(), bean.getWindSpeed());
					notifyResponse(response);
				} catch (IOException e) {
					Log.e(TAG, "run1:  ", e);
					notifyError(e);
				}
			}
		}).start();

	}

	private void notifyResponse(final DayCard response) {
		handler.post(new Runnable() {
			@Override
			public void run() {
				view.showProgress(false);
				view.showData(response);
			}
		});
	}

	private void notifyError(final Throwable e) {
		handler.post(new Runnable() {
			@Override
			public void run() {
				view.showProgress(false);
				view.showError(e.getMessage());
			}
		});
	}
}
