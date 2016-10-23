package by.mrkip.apps.epamandroidtraining.dataobjects;

import java.util.Calendar;

/**
 * Created by kip on 10.10.2016.
 */

public class UserProfileM {
	private UserProfile userProfile;

	public UserProfileM(UserProfile up) {
		userProfile = up;
	}

	public int getAge() {
		Calendar now = Calendar.getInstance();
		Calendar dob = Calendar.getInstance();
		dob.setTime(userProfile.getBirthDate());

		int year1 = now.get(Calendar.YEAR);
		int year2 = dob.get(Calendar.YEAR);
		int age = year1 - year2;
		int month1 = now.get(Calendar.MONTH);
		int month2 = dob.get(Calendar.MONTH);
		if (month2 > month1) {
			age--;
		} else if (month1 == month2) {
			int day1 = now.get(Calendar.DAY_OF_MONTH);
			int day2 = dob.get(Calendar.DAY_OF_MONTH);
			if (day2 > day1) {
				age--;
			}
		}
		return age;
	}

	public String getBirthSeason() {
		String res;
		Calendar dob = Calendar.getInstance();
		dob.setTime(userProfile.getBirthDate());

		int month = dob.get(Calendar.MONTH);

		switch (month) {
			case 12:
			case 1:
			case 2:
				res = "winter";
				break;
			case 3:
			case 4:
			case 5:
				res = "Spring";
				break;
			case 6:
			case 7:
			case 8:
				res = "Summer";
				break;
			case 9:
			case 10:
			case 11:
				res = "Autumn";
				break;
			default:
				res = "error";

		}
		return res;
	}

	public String getEmailTail() {
		return userProfile.getEmail().substring(userProfile.getEmail().indexOf('@')+1, userProfile.getEmail().length());
	}

	public String getEmailTailLess() {
		return userProfile.getEmail().substring(0, userProfile.getEmail().indexOf('@') );
	}

	public String getStrIdForJSON() {

		return userProfile.getName().concat(":".concat(getEmailTailLess().concat("-".concat(getBirthSeason().concat(".".concat(getEmailTail()))))));
	}

}
