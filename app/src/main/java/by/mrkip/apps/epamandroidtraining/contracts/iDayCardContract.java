package by.mrkip.apps.epamandroidtraining.contracts;

import by.mrkip.apps.epamandroidtraining.model.DayCard;

/**
 * Created by kip on 13.10.2016.
 */

public interface IDayCardContract {
	interface DayCardView {
		void showData(DayCard data);

		void showError(String message);

		void showProgress(boolean isInProgress);
	}

	interface Presenter {
		void onReady();
	}

}
