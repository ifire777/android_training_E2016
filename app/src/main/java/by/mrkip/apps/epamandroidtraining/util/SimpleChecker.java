package by.mrkip.apps.epamandroidtraining.util;


import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class SimpleChecker {


	public final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public SimpleChecker() {
	}

	public boolean checkCaptcha(String inputVal, String originVal) {
		return inputVal.equals(originVal);
	}

	public boolean checkName(String name) {

		 return !(name.equals("admin") || name.equals(""));
	}

	public boolean checkEmail(String email) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		return pattern.matcher(email).matches();
	}


	public Date generDoB() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR,(int)( 1980+Math.random()*20));
		calendar.set(Calendar.DAY_OF_YEAR, (int)( 1+Math.random()*365));
		return calendar.getTime();
	}

}


