package kumarPoswal.salinder1;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.takeHomeTest.base.TestBase;
import com.takeHomeTest.pages.JavaScriptAlertsPage;
import com.takeHomeTest.pages.TheInternetPage;

public class JavaAcriptAlertsTest extends TestBase {
	
	JavaScriptAlertsPage javaScriptAlertsPage;
	TheInternetPage theInternetPage;

	@BeforeMethod
	public void startBorwserSession() {
		intialization();
		theInternetPage = new TheInternetPage(webDriver, true);

	}

	@Test
	public void jsAlertTest() {
		javaScriptAlertsPage = theInternetPage.clickjavaScriptPage();
		javaScriptAlertsPage.clickjsAlertBtn();
		Assert.assertEquals(javaScriptAlertsPage.getjsAlertMessage(), "I am a JS Alert", "Text does not match");

	}
	
	@Test
	public void jsConfirmTest() {
		javaScriptAlertsPage = theInternetPage.clickjavaScriptPage();
		javaScriptAlertsPage.clickjsConfirmBtn();
		Assert.assertEquals(javaScriptAlertsPage.confirmJsMessage(), "I am a JS Confirm", "Text does not match");
		javaScriptAlertsPage.confirmJsAccept();

	}
	
	@Test 
	public void jsPrmoptTest() {
		javaScriptAlertsPage = theInternetPage.clickjavaScriptPage();
		javaScriptAlertsPage.clickjsjsPromptBtn();
		javaScriptAlertsPage.jsPromptsendKeysGetText("print this");
		Assert.assertEquals(javaScriptAlertsPage.confimtPromptMsg(), "You entered: print this", "Text does not match");

	}
	

	@AfterMethod
	public void quitBrowserSession() {
		quitBrowser();
	}

}
