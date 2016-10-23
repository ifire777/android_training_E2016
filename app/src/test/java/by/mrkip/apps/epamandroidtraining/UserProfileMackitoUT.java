package by.mrkip.apps.epamandroidtraining;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import by.mrkip.apps.epamandroidtraining.dataobjects.UserProfile;
import by.mrkip.apps.epamandroidtraining.dataobjects.UserProfileM;

import static org.junit.Assert.assertEquals;

public class UserProfileMackitoUT {
	private UserProfileM userProfileM;
	@Mock
	private UserProfile userProfile;

	private Date date;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

		Mockito.when(userProfile.getName()).thenReturn("Alex");
		Mockito.when(userProfile.getEmail()).thenReturn("alex_ad@mail.by");
		SimpleDateFormat parser = new SimpleDateFormat("dd.MM.yyyy");
		try {
			date = parser.parse("10.02.2010");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Mockito.when(userProfile.getBirthDate()).thenReturn(date);

		userProfileM = Mockito.spy(new UserProfileM(userProfile));

	}


	@Test
	public void getBirthSeasonTest() {
		assertEquals(userProfileM.getBirthSeason(), "winter");
	}

	@Test
	public void geEmailTailTest() {
		assertEquals(userProfileM.getEmailTail(), "mail.by");
	}

	@Test
	public void getEmailTailLessTest() {
		assertEquals(userProfileM.getEmailTailLess(), "alex_ad");
	}

	@Test
	public void getStrIdForJSONTest() {
		assertEquals(userProfileM.getStrIdForJSON(), "Alex:alex_ad-winter.mail.by");
	}



}
