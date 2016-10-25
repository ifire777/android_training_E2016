package by.mrkip.apps.epamandroidtraining.presenters;


import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import by.mrkip.apps.epamandroidtraining.ApiManager;
import by.mrkip.apps.epamandroidtraining.contracts.IWeatherCardContract;
import by.mrkip.apps.epamandroidtraining.model.DayWeatherCard;
import by.mrkip.apps.epamandroidtraining.model.HttpRequestModel;
import by.mrkip.backend.weather.myApi.MyApi;
import by.mrkip.libs.http.HttpClient;
import by.mrkip.libs.http.httpUtils.urlGETStrBuilder;

import static android.content.ContentValues.TAG;


public class DayCardPresenter implements IWeatherCardContract.Presenter {
	private static final String FUTURE_WEATHER_URL = "http://api.worldweatheronline.com/free/v2/weather.ashx";
	private static final String PAST_WEATHER_URL = "http://api.worldweatheronline.com/free/v2/weather.ashx";
	private static final String WEATHER_API_KEY = "de2eebb1950884eb9e557aaf3197f";
	private static final String QUERY_PARAM_Q = "q";
	private static final String QUERY_PARAM_FORMAT = "format";
	private static final String QUERY_PARAM_DATE = "date";
	private static final String QUERY_PARAM_INCLUDELOCATION = "includelocation";
	private static final String QUERY_PARAM_KEY = "key";
	private static final String QUERY_PARAM_TP = "tp";
	private static final String QUERY_PARAM_ENDDATE = "enddate";


	private IWeatherCardContract.DayCardView view;
	private Handler handler;

	public DayCardPresenter(@NonNull IWeatherCardContract.DayCardView view) {
		this.view = view;
		handler = new Handler(Looper.getMainLooper());
	}

	@Override
	public void onReady(String coorLan, String coorLon, String dt) {
		view.showProgress(true);
		//loadDataFromSelfBackend();
		loadDayCardData(getFutureDayWeatherQuery(coorLan, coorLon, dt));
	}

	@Override
	public void onReady(String coorLan, String coorLon, String startDt, String endDt) {
		view.showProgress(true);
		//loadDataFromSelfBackend();
		loadDayCardData(getPastDayWeatherQuery(coorLan, coorLon, startDt, endDt));
	}

	private void loadDayCardData(final String pGetUrl) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				HttpRequestModel httpGet = new HttpRequestModel();
				HttpClient httpClient = new HttpClient();
				try {

					httpGet.setUrl(pGetUrl);

					String responseStr = httpClient.get(httpGet.getUrl());

					JSONObject dayCardJSONObj = new JSONObject(responseStr)
							.getJSONObject("data")
							.getJSONArray("current_condition")
							.getJSONObject(0);
					DayWeatherCard respObject = new DayWeatherCard().fillFutureWeatherFromJson(dayCardJSONObj);


					//Gson gson = new GsonBuilder().registerTypeAdapter(UFDate.class, new DateCast()).create();
					//RootDataJO dayCardByGson = gson.fromJson(responseStr, RootDataJO.class);
					//fill some response Object fild from Gson-way parsed object
					//respObject.setDate(dayCardByGson.getData().getWeatherJA().get(0).getCastomDate().getUfDate());

					notifyResponse(respObject);

				} catch (IOException | JSONException e) {
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
					by.mrkip.backend.weather.myApi.model.DayWeatherCard bean;
					bean = call.execute();
					DayWeatherCard response = new DayWeatherCard(bean.getWeatherType(), bean.getTempC(), bean.getHumidity(), bean.getWindSpeed());
					notifyResponse(response);
				} catch (IOException e) {
					Log.e(TAG, "run1:  ", e);
					notifyError(e);
				}
			}
		}).start();

	}

	private void notifyResponse(final DayWeatherCard response) {
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


	private String getFutureDayWeatherQuery(String coorLan, String coorLon, String dt) {
		return new urlGETStrBuilder(FUTURE_WEATHER_URL)
				.addParam(QUERY_PARAM_Q, coorLan + "," + coorLon)
				.addParam(QUERY_PARAM_FORMAT, "json")
				.addParam(QUERY_PARAM_DATE, dt)
				.addParam(QUERY_PARAM_INCLUDELOCATION, "yes")
				.addParam(QUERY_PARAM_KEY, WEATHER_API_KEY)
				.addParam(QUERY_PARAM_TP, "24")
				.getUrl();
	}

	private String getPastDayWeatherQuery(String coorLan, String coorLon, String startDt, String endDt) {
		return new urlGETStrBuilder(FUTURE_WEATHER_URL)
				.addParam(QUERY_PARAM_Q, coorLan + "," + coorLon)
				.addParam(QUERY_PARAM_FORMAT, "json")
				.addParam(QUERY_PARAM_DATE, startDt)
				.addParam(QUERY_PARAM_ENDDATE, endDt)
				.addParam(QUERY_PARAM_INCLUDELOCATION, "yes")
				.addParam(QUERY_PARAM_KEY, WEATHER_API_KEY)
				.addParam(QUERY_PARAM_TP, "24")
				.getUrl();
	}

}
