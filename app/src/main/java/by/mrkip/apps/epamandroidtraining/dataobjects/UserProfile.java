package by.mrkip.apps.epamandroidtraining.dataobjects;


import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class UserProfile implements Serializable{
	private String name;
	private String email;
	private Date birthDate;

	public UserProfile(String name, String email, Date birthDate)  {
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getAge(Date birth) {
		Calendar now = Calendar.getInstance();
		Calendar dob = Calendar.getInstance();
		dob.setTime(birth);

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

	public String getBirthSeason(Date birth) {
		String res;
		Calendar dob = Calendar.getInstance();
		dob.setTime(birth);

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

	public String getEmailHost(String email) {
		return email.substring(email.indexOf('@'), email.length());
	}


}
