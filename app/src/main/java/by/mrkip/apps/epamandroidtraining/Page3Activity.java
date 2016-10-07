package by.mrkip.apps.epamandroidtraining;

import android.content.Intent;
import android.os.Bundle;


/**
 * Created by kip on 04.10.2016.
 */


public class Page3Activity extends PageActivity {

    public  final String A_3 = "a3";
    public final int PAGE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       pageNum= PAGE;
    }
    @Override
    protected void goNextPage() {
        startActivity(new Intent(this,MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME));
    }

    /*@Override
    public void onBackPressed()
    {
        startActivity(new Intent(this,Page2Activity.class));
        super.onBackPressed();
    }*/

    @Override
    protected boolean init() {
    tvQuestion.setText(R.string.q3);
    etAnswer.setText(sharedPrefManager.getStringParam(A_3,""));
        return true;
    }
}
