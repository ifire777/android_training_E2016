package by.mrkip.apps.epamandroidtraining.contracts;

import by.mrkip.apps.epamandroidtraining.model.DayWeatherCard;

public interface IWeatherCardContract {
	interface DayCardView {
		void showData(DayWeatherCard data);

		void showError(String message);

		void showProgress(boolean isInProgress);
	}



	interface Presenter {
		void onReady(String coorLan, String coorLon, String dt);
		void onReady(String coorLan, String coorLon, String startDt,String endDt);

	}

}
