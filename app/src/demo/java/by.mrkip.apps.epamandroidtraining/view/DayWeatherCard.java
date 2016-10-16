package by.mrkip.apps.epamandroidtraining.view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.TextView;

import by.mrkip.apps.epamandroidtraining.R;
import by.mrkip.apps.epamandroidtraining.contracts.IDayCardContract;
import by.mrkip.apps.epamandroidtraining.model.DayCard;
import by.mrkip.apps.epamandroidtraining.presenters.DayCardPresenter;


public class DayWeatherCard extends CardView implements IDayCardContract.DayCardView {
	private IDayCardContract.Presenter presenter;

	private TextView tvDegree;
	private TextView tvHumisity;
	private TextView tvWindSpeed;

	public String deg;
	public String hum;
	public String wind;


	public DayWeatherCard(Context context) {
		super(context);
		presenter = new DayCardPresenter(this);
		init();
	}

	public DayWeatherCard(Context context, AttributeSet attrs) {
		super(context, attrs);
		presenter = new DayCardPresenter(this);
		init();
	}

	public DayWeatherCard(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		presenter = new DayCardPresenter(this);
		init();


	}

	private void init() {


		presenter.onReady();


	}


	@Override
	public void showData(DayCard dayCard) {
		inflate(getContext(), R.layout.view_daycard, this);
		tvDegree = (TextView) findViewById(R.id.dwc_temperature);
		tvHumisity = (TextView) findViewById(R.id.dwc_humisity);
		tvWindSpeed = (TextView) findViewById(R.id.dwc_windspeed);

		tvDegree.setText(dayCard.getTempC());
		tvHumisity.setText("demo version");   //don't show editional weather params in demo flavors
		tvWindSpeed.setText("demo version");


	}

	@Override
	public void showError(String message) {

	}

	@Override
	public void showProgress(boolean isInProgress) {

	}
}
