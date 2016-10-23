package by.mrkip.apps.epamandroidtraining;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import by.mrkip.apps.epamandroidtraining.util.SimpleChecker;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;


public class SimpleCheckerUnitTest {

	private SimpleChecker simpleChecker;
	private String strPar1;
	private String strPar2;

	@Before
	public void init() {
		simpleChecker = new SimpleChecker();

	}

	@After
	public void close() {
		simpleChecker = null;
	}

	@Test
	public void checkCaptcha_isCorrect1() throws Exception {
		strPar1 = Long.toHexString(Double.doubleToLongBits(Math.random())) + "1";
		strPar2 = Long.toHexString(Double.doubleToLongBits(Math.random())) + "2";

		assertEquals(simpleChecker.checkCaptcha(strPar1, strPar2), false);
	}

	@Test
	public void checkCaptcha_isCorrect2() throws Exception {
		strPar1 = Long.toHexString(Double.doubleToLongBits(Math.random())) + "1";
		strPar2 = Long.toHexString(Double.doubleToLongBits(Math.random())) + "2";

		assertEquals(simpleChecker.checkCaptcha(strPar1, strPar1), true);
		assertEquals(simpleChecker.checkCaptcha(strPar2, strPar2), true);
	}

	@Test
	public void checkName_isCorrect1() throws Exception {

		assertEquals(simpleChecker.checkName("admin"), false);
		assertEquals(simpleChecker.checkName(""), false);
	}

	@Test
	public void checkName_isCorrect2() throws Exception {
		strPar1 = Long.toHexString(Double.doubleToLongBits(Math.random()));

		assertEquals(simpleChecker.checkName(strPar1), true);

	}

	@Test
	public void checkEmail_isCorrect1() throws Exception {
		assertEquals(simpleChecker.checkEmail("wer@tt.by"), true);
	}

	@Test
	public void checkEmail_isCorrect2() throws Exception {
		assertEquals(simpleChecker.checkEmail("wertt.by"), false);
	}

	@Test
	public void checkEmail_isCorrect3() throws Exception {
		assertEquals(simpleChecker.checkEmail("wer@ttby"), false);
	}

	@Test
	public void checkEmail_isCorrect4() throws Exception {
		assertEquals(simpleChecker.checkEmail("we.r@tt.b@y"), false);
	}

	@Test
	public void generDoB_isCorrect1() throws Exception {
		assertNotNull(simpleChecker.generDoB());
	}

}
