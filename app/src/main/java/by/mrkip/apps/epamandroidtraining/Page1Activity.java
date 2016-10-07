package by.mrkip.apps.epamandroidtraining;

import android.content.Intent;
import android.os.Bundle;


/**
 * Created by kip on 04.10.2016.
 */

public class Page1Activity extends PageActivity {

	public final String A_1 = "a1";
	public final int PAGE = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		pageNum = PAGE;
	}

	@Override
	protected void goNextPage() {
		// sharedPrefManager.saveParam(A_1,etAnswer.getText().toString());
		startActivity(new Intent(this, Page2Activity.class));
	}

	@Override
	protected boolean init() {
		tvQuestion.setText(getString(R.string.q1));
		etAnswer.setText(sharedPrefManager.getStringParam(A_1, ""));
		return true;
	}
}
