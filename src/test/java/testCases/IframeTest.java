package testCases;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pageObjectModel.HomePage;
import pageObjectModel.IframePage;

public class IframeTest extends BaseTest{
	@Test
	public void iFrame() {
		HomePage homePage = new HomePage(driver);
		IframePage iframe = homePage.clickFrame();
		String message = "type here";
		iframe.switchAndText(message);
		assertTrue(iframe.verifyText().equals(message));
	}
}
