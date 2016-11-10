package by.mrkip.apps.weatherarchive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import by.mrkip.apps.weatherarchive.adapters.PlacesAutocompleteAdapter;
import by.mrkip.libs.http.httpHelper.GetQueryBuilder;

import static by.mrkip.apps.weatherarchive.globalObj.Api.PLACES_API_BASE_URI;
import static by.mrkip.apps.weatherarchive.globalObj.Api.PLACES_API_OUT_JSON;
import static by.mrkip.apps.weatherarchive.globalObj.Api.PLACE_API_KEY;
import static by.mrkip.apps.weatherarchive.globalObj.Api.PLACE_API_TYPE_DETAILS;
import static by.mrkip.apps.weatherarchive.globalObj.Api.QUERY_PARAM_KEY;
import static by.mrkip.apps.weatherarchive.globalObj.Api.QUERY_PARAM_PLACEID;


public class CitySelectionActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

	public static final int COUNT_CORE = Runtime.getRuntime().availableProcessors();
	private ExecutorService executorService;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cityselection);
		AutoCompleteTextView autoCompView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);

		autoCompView.setAdapter(new PlacesAutocompleteAdapter(this, R.layout.list_city_autocomplete_line));
		autoCompView.setOnItemClickListener(this);

		this.executorService = Executors.newFixedThreadPool(COUNT_CORE);
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
		String str = (String) adapterView.getItemAtPosition(position);
		Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
	}

	private void getSelectedCityData(String urlRequest) {
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				/*HttpClient httpClient = new HttpClient();
				try {
				//	String = httpClient.getResult(urlRequest, new CitySelectionPresenter());
				//	return (ArrayList<String>) testL;

				} catch (IOException e) {
					Log.e(this.toString(), this.toString() + "|IOException :", e);


				} catch (Exception e) {
					Log.e(this.toString(), this.toString() + "|Exception:", e);


				}*/

			}
		});
	}

	private String getCityDataQuery(String placeID) throws UnsupportedEncodingException {
		return new GetQueryBuilder(PLACES_API_BASE_URI + PLACE_API_TYPE_DETAILS + PLACES_API_OUT_JSON)
				.addParam(QUERY_PARAM_KEY, PLACE_API_KEY)
				.addParam(QUERY_PARAM_PLACEID, placeID)
				.getUrl();
	}

}
