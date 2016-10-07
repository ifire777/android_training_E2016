package by.mrkip.apps.epamandroidtraining;

import android.content.Intent;
import android.os.Bundle;


/**
 * Created by kip on 04.10.2016.
 */


public class Page2Activity extends PageActivity {

	public final String A_2 = "a2";
	public final int PAGE = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		pageNum = PAGE;
	}

	@Override
	protected void goNextPage() {
		// sharedPrefManager.saveParam(A_2,etAnswer.getText().toString());
		startActivity(new Intent(this, Page3Activity.class));
	}

	@Override
	protected boolean init() {
		tvQuestion.setText(R.string.q2);
		etAnswer.setText(sharedPrefManager.getStringParam(A_2, ""));
		return true;
	}

   /* @Override
    public void onBackPressed()
    {
        startActivity(new Intent(this,Page1Activity.class));
        super.onBackPressed();  // optional depending on your needs
    }*/
}
