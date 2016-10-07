package by.mrkip.apps.epamandroidtraining;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import by.mrkip.apps.epamandroidtraining.util.SharedPrefManager;


public abstract class PageActivity extends AppCompatActivity {
	protected SharedPrefManager sharedPrefManager;

	protected   final String STATUS = "status";
	protected   final String APP_STORAGE = "appStorage";

	protected   Integer STATUS_VALUE;

	protected TextView tvQuestion;
	protected EditText etAnswer;
	protected Button btNext;

	protected int pageNum = 0;
	// private String LOG_TAG="mApp";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_page);
		sharedPrefManager = new SharedPrefManager(APP_STORAGE, this);
		STATUS_VALUE = Integer.valueOf(sharedPrefManager.getStringParam(STATUS));
		tvQuestion = (TextView) findViewById(R.id.tv_question);
		btNext = (Button) findViewById(R.id.bt_next);
		btNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (STATUS_VALUE < pageNum + 1) {
					sharedPrefManager.saveParam(STATUS, String.valueOf(pageNum + 1));
					//STATUS_VALUE = pageNum + 1;
				}
				goNextPage();
			}
		});

		etAnswer = (EditText) findViewById(R.id.et_answer);
		init();
		etAnswer.requestFocus();

	}

	@Override
	protected void onStop() {
		super.onStop();
		sharedPrefManager.saveParam("a".concat(String.valueOf(pageNum)), etAnswer.getText().toString());

	}


	protected abstract void goNextPage();

	protected abstract boolean init();
}
