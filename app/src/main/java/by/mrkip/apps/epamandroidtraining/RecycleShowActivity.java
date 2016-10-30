package by.mrkip.apps.epamandroidtraining;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import java.io.IOException;
import java.util.List;

import by.mrkip.apps.epamandroidtraining.adapters.WeatherCardAdapter;
import by.mrkip.apps.epamandroidtraining.model.WeatherCard;
import by.mrkip.apps.epamandroidtraining.presenters.PastWeatherListPresenter;
import by.mrkip.apps.epamandroidtraining.util.ContextHolder;
import by.mrkip.libs.http.HttpClient;
import by.mrkip.libs.http.httpUtils.urlGETStrBuilder;

import static android.content.ContentValues.TAG;

public class RecycleShowActivity extends AppCompatActivity {
	private static final String PAST_WEATHER_URL = "http://api.worldweatheronline.com/free/v2/past-weather.ashx";
	private static final String WEATHER_API_KEY = "de2eebb1950884eb9e557aaf3197f";
	private static final String QUERY_PARAM_Q = "q";
	private static final String QUERY_PARAM_FORMAT = "format";
	private static final String QUERY_PARAM_DATE = "date";
	private static final String QUERY_PARAM_INCLUDELOCATION = "includelocation";
	private static final String QUERY_PARAM_KEY = "key";
	private static final String QUERY_PARAM_TP = "tp";
	private static final String QUERY_PARAM_ENDDATE = "enddate";


	private List<WeatherCard> cardsList;
	private RecyclerView recyclerView;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ContextHolder.getInstance().setContext(getApplicationContext());

		setContentView(R.layout.activity_recyclershow);
		recyclerView = (RecyclerView) findViewById(R.id.rsa_view_recycle);

		initRecyclerView();

		new MyTask().execute(getPastDayWeatherQuery("53.6667", "23.8333", "2016-09-23", "2016-10-23"));

	}


	private void initRecyclerView() {
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		recyclerView.setAdapter(new WeatherCardAdapter(cardsList, 0));
		setItemTouchHelper();
	}


	private void setList(List<WeatherCard> pList) {

		this.cardsList = pList;
		((WeatherCardAdapter) recyclerView.getAdapter()).addItems(pList);

	}

	private String getPastDayWeatherQuery(String coorLan, String coorLon, String startDt, String endDt) {
		return new urlGETStrBuilder(PAST_WEATHER_URL)
				.addParam(QUERY_PARAM_Q, coorLan + "," + coorLon)
				.addParam(QUERY_PARAM_FORMAT, "json")
				.addParam(QUERY_PARAM_DATE, startDt)
				.addParam(QUERY_PARAM_ENDDATE, endDt)
				.addParam(QUERY_PARAM_INCLUDELOCATION, "yes")
				.addParam(QUERY_PARAM_KEY, WEATHER_API_KEY)
				.addParam(QUERY_PARAM_TP, "24")
				.getUrl();
	}

	private void setItemTouchHelper() {
		ItemTouchHelper.SimpleCallback swipeTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
			@Override
			public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
				return false;
			}

			@Override
			public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
				WeatherCardAdapter adapter = (WeatherCardAdapter) recyclerView.getAdapter();
				adapter.remove(viewHolder.getAdapterPosition());
			}
		};
		ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeTouchCallback);
		itemTouchHelper.attachToRecyclerView(recyclerView);
	}

	class MyTask extends AsyncTask<String, Integer, List<WeatherCard>> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();

		}

		@Override
		protected List<WeatherCard> doInBackground(String... args) {
			HttpClient httpClient = new HttpClient();
			try {

				return httpClient.getResult(args[0], new PastWeatherListPresenter());

			} catch (IOException e) {
				Log.e(TAG, this.toString() + ":", e);

			} catch (Exception e) {
				Log.e(TAG, this.toString() + ":", e);

			}
			return null;
		}

		@Override
		protected void onProgressUpdate(Integer... vd) {
			super.onProgressUpdate(vd);

		}

		@Override
		protected void onPostExecute(List<WeatherCard> result) {
			//	super.onPostExecute(result);
			setList(result);

		}

	}


}
