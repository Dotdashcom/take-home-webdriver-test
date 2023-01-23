package RamanpreetSinghtest.SeleniumTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.JavaScriptAlertsPage;
import TestComponents.BaseTest;

public class JavaScriptAlertTest extends BaseTest {

	@Test
	public void javaScriptAlert() throws InterruptedException {
		JavaScriptAlertsPage javaScriptalertspage = landingpage.getjavascriptPage();
		String alerttext = javaScriptalertspage.pressjsalert();
		Assert.assertEquals(alerttext, "I am a JS Alert");
		Thread.sleep(5000);
		String confirmMessage = javaScriptalertspage.pressjsconfirm();
		
		Assert.assertEquals(confirmMessage, "You clicked: Ok");
		Thread.sleep(5000);
		String promptMessage = javaScriptalertspage.pressjsprompt();
		
		Assert.assertEquals(promptMessage, "You entered: My name is Raman");

	}

}
