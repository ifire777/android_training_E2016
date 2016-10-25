package by.mrkip.apps.epamandroidtraining.view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.TextView;

import by.mrkip.apps.epamandroidtraining.R;
import by.mrkip.apps.epamandroidtraining.contracts.IWeatherCardContract;
import by.mrkip.apps.epamandroidtraining.presenters.DayCardPresenter;


public class DayWeatherCardView extends CardView implements IWeatherCardContract.DayCardView {
	private IWeatherCardContract.Presenter presenter;

	private TextView tvDegree;
	private TextView tvHumisity;
	private TextView tvWindSpeed;
	private TextView tvDate;

	public String deg;
	public String hum;
	public String wind;


	public DayWeatherCardView(Context context) {
		super(context);
		presenter = new DayCardPresenter(this);
		init();
	}

	public DayWeatherCardView(Context context, AttributeSet attrs) {
		super(context, attrs);
		presenter = new DayCardPresenter(this);
		init();
	}

	public DayWeatherCardView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		presenter = new DayCardPresenter(this);
		init();


	}

	private void init() {
		presenter.onReady("53.6667", "23.8333", "2016-10-23");

	}


	@Override
	public void showData(by.mrkip.apps.epamandroidtraining.model.DayWeatherCard dayCard) {
		inflate(getContext(), R.layout.view_daycard, this);
		tvDegree = (TextView) findViewById(R.id.dwc_temperature);
		tvHumisity = (TextView) findViewById(R.id.dwc_humisity);
		tvWindSpeed = (TextView) findViewById(R.id.dwc_windspeed);
		tvDate = (TextView) findViewById(R.id.dwc_todaydate);

		tvDegree.setText(dayCard.getTempC());
		tvHumisity.setText(dayCard.getHumidity());
		tvWindSpeed.setText(dayCard.getWindSpeed());
		tvDate.setText(dayCard.getDate().toString());

	}

	@Override
	public void showError(String message) {

	}

	@Override
	public void showProgress(boolean isInProgress) {

	}
}
