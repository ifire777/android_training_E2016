package by.mrkip.apps.epamandroidtraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import by.mrkip.apps.epamandroidtraining.dataobjects.UserProfile;
import by.mrkip.apps.epamandroidtraining.util.CapchaGenerator;
import by.mrkip.apps.epamandroidtraining.util.SimpleChecker;
import by.mrkip.apps.epamandroidtraining.view.DayWeatherCard;
import by.mrkip.apps.epamandroidtraining.view.IcButton;


public class UserRegActivity extends AppCompatActivity implements View.OnClickListener {
	SimpleChecker simpleChecker;

	private EditText etName;
	private EditText etCaptcha;
	private EditText etMail;

	private TextView tvCaptcha;

	private IcButton btCheckName;
	private Button btSave;

	private String captchaVal;
	private DayWeatherCard dayWeatherCard;


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_userreg);


		simpleChecker = new SimpleChecker();

		etName = (EditText) findViewById(R.id.et_name);
		etCaptcha = (EditText) findViewById(R.id.et_captcha);
		etMail = (EditText) findViewById(R.id.et_email);

		tvCaptcha = (TextView) findViewById(R.id.tv_captcha);

		btSave = (Button) findViewById(R.id.bt_save);
		btSave.setOnClickListener(this);
		btCheckName = (IcButton) findViewById(R.id.bt_checkname);
		btCheckName.setOnClickListener(this);

		captchaVal = new CapchaGenerator().getCapcha();
		tvCaptcha.setText(captchaVal);

		dayWeatherCard = (DayWeatherCard) findViewById(R.id.card_dayweather);


				/*TextView tvWeatherInfo = (TextView) findViewById(R.id.tv_weatherinfo);
		tvWeatherInfo.setText("t(C)="+dayWeatherCard.deg+"; h="+dayWeatherCard.hum+"; w="+dayWeatherCard.wind+"m/sec");
*/

	}


	@Override
	public void onClick(View v) {
		if (v.equals(btSave)) {
			if (simpleChecker.checkName(String.valueOf(etName.getText())) && simpleChecker.checkEmail(String.valueOf(etMail.getText())) &&
					simpleChecker.checkCaptcha(String.valueOf(etCaptcha.getText()), this.captchaVal)) {
				Intent intent = new Intent(this, MainActivity.class);
				intent.putExtra("User", new UserProfile(String.valueOf(etName.getText()), String.valueOf(etMail.getText()), simpleChecker.generDoB()));
				startActivity(intent);
			}

		}
		if (v.equals(btCheckName)) {
			if (simpleChecker.checkName(String.valueOf(etName))) {
				btCheckName.setVisibility(View.INVISIBLE);
				etName.setEnabled(Boolean.FALSE);
			}

		}
	}

}
