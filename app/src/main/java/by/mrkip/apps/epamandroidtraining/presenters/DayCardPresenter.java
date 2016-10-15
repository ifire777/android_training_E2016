package by.mrkip.apps.epamandroidtraining.presenters;


import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;

import by.mrkip.apps.epamandroidtraining.ApiManager;
import by.mrkip.apps.epamandroidtraining.contracts.IDayCardContract;
import by.mrkip.apps.epamandroidtraining.model.DayCard;
import by.mrkip.backend.weather.myApi.MyApi;
import by.mrkip.backend.weather.myApi.model.DayWeatherCard;

import static android.content.ContentValues.TAG;

/**
 * Created by kip on 13.10.2016.
 */

public class DayCardPresenter implements IDayCardContract.Presenter {
	private IDayCardContract.DayCardView view;
	private Handler handler;

	public DayCardPresenter(@NonNull IDayCardContract.DayCardView view) {
		this.view = view;
		handler = new Handler(Looper.getMainLooper());
	}

	@Override
	public void onReady() {
		view.showProgress(true);
		loadData();
	}

	private void loadData() {

		new Thread( new Runnable() {
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
