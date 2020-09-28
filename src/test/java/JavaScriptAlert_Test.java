import org.testng.annotations.Test;
import org.testng.Assert;
import base.BaseTest;
import base.WebLink;
import pages.JavaScriptAlertPage;

public class JavaScriptAlert_Test extends BaseTest {
	JavaScriptAlertPage page = null;

	@Test
	public void verifyJsAlertMsg() {// I am a JS Alert
		page = new JavaScriptAlertPage(driver);
		try {
			driver.get(WebLink.javaScriptAlertpageUrl);
			page.clickJSAlert();
			Assert.assertEquals(page.verifyAlertMsg("I am a JS Alert"), true);
			//driver.close();
		} catch (Exception e) {
			Assert.assertTrue(false);
			e.getLocalizedMessage();
		}
	}
	@Test
	public void verifyJsPrompt() {// I am a JS Alert
		page = new JavaScriptAlertPage(driver);
		try {
			driver.get(WebLink.javaScriptAlertpageUrl);
			page.jsPrompt();
			page.enterAlertText("Test");
		//	driver.close();
			Assert.assertEquals(page.isResultMatched("You entered: "+"Test"), true);
		} catch (Exception e) {
			Assert.assertTrue(false);
			e.getLocalizedMessage();
		}
	}

	@Test
	public void verifyJsConfirm() {// I am a JS Alert
		page = new JavaScriptAlertPage(driver);
		try {
			driver.get(WebLink.javaScriptAlertpageUrl);
			page.clickJsConfirm();
		//	driver.close();
			Assert.assertEquals(page.isResultMatched("You clicked: Ok"), true);
		} catch (Exception e) {
			Assert.assertTrue(false);
			e.getLocalizedMessage();
		}
	}
}
