package by.mrkip.apps.weatherarchive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import by.mrkip.apps.weatherarchive.adapters.GooglePlacesAutocompleteAdapter;


public class CitySelectionActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cityselection);
		AutoCompleteTextView autoCompView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);

		autoCompView.setAdapter(new GooglePlacesAutocompleteAdapter(this, R.layout.list_city_autocomplete_line));
		autoCompView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
		String str = (String) adapterView.getItemAtPosition(position);
		Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
	}


}
