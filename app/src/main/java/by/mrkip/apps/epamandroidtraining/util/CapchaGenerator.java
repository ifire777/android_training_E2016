package by.mrkip.apps.epamandroidtraining.util;


import android.util.Log;

public class CapchaGenerator {


	public CapchaGenerator() {

	}

	public String getCapcha(){
		Log.d("mapp",""+System.currentTimeMillis());
		return String.valueOf(System.currentTimeMillis()).substring(9,12);
	}
}
