package by.mrkip.apps.epamandroidtraining;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import by.mrkip.apps.epamandroidtraining.util.SharedPrefManager;


public class IntroActivity extends Activity {

	private final String STATUS = "status";
	private final String APP_STORAGE = "appStorage";

	private Integer STATUS_VALUE;


	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_main);
		STATUS_VALUE = Integer.valueOf(new SharedPrefManager(APP_STORAGE, this).getStringParam(STATUS));
		Intent intent;

		switch (STATUS_VALUE) {
			case -1:
				intent = new Intent(this, Page1Activity.class);
				break;
			case 1:
				intent = new Intent(this, Page1Activity.class);
				break;
			case 2:
				intent = new Intent(this, Page2Activity.class);
				break;
			case 3:
				intent = new Intent(this, Page3Activity.class);
				break;
			case 4:
				intent = new Intent(this, MainActivity.class);
				break;
			case 5:
				intent = new Intent(this, MainActivity.class);
				break;
			case 6:
				intent = new Intent(this, MainActivity.class);
				break;
			default:
				intent = null;
				break;
		}

		if (intent != null) {
			startActivity(intent);
		}

	}

	@Override
	protected void onResume() {
		super.onResume();
		finish();
	}
}
