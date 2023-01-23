package RamanpreetSinghtest.SeleniumTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.CheckboxPage;
import TestComponents.BaseTest;

public class CheckBoxTest extends BaseTest {

	@Test
	public void checkboxtest() throws InterruptedException {
		CheckboxPage checkboxpage = landingpage.getcheckboxPage();
		boolean boo = checkboxpage.selectcheckbox();
		
		Assert.assertTrue(boo);
		Thread.sleep(3000);
	}

}
