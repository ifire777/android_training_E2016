package by.mrkip.apps.epamandroidtraining.dataobjects;


import java.io.Serializable;
import java.util.Date;

public class UserProfile implements Serializable {
	private String name;
	private String email;
	private Date birthDate;

	public UserProfile(String name, String email, Date birthDate) {
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


}
