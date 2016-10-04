package by.mrkip.apps.epamandroidtraining;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import by.mrkip.apps.epamandroidtraining.util.SharedPrefManager;

/**
 * Created by kip on 04.10.2016.
 */

public abstract class PageActivity extends AppCompatActivity {
   protected  SharedPrefManager sharedPrefManager;

    protected  TextView tvQuestion;
    protected EditText etAnswer;
    protected Button btNext;

    protected int pageNum=0;
   // private String LOG_TAG="mApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        sharedPrefManager= new SharedPrefManager(IntroActivity.APP_STORAGE,this);
        tvQuestion = (TextView) findViewById(R.id.tv_question);
        btNext=(Button) findViewById(R.id.bt_next);
        btNext.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(IntroActivity.STATUS_VALUE<pageNum + 1) {
                    sharedPrefManager.saveParam(IntroActivity.STATUS, String.valueOf(pageNum + 1));
                    IntroActivity.STATUS_VALUE=pageNum + 1;
                }
                goNextPage();
            }
        });

        etAnswer= (EditText) findViewById(R.id.et_answer);
        init();
        etAnswer.requestFocus();

    }

    @Override
    protected void onStop() {
        super.onStop();
        sharedPrefManager.saveParam("a".concat(String.valueOf(pageNum)),etAnswer.getText().toString());

    }



    protected abstract void goNextPage();
    protected abstract boolean init();
}
