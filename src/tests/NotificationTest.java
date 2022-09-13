package tests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Util.TestBase;
import pages.NotificationPage;

public class NotificationTest extends TestBase {
	NotificationPage np=new NotificationPage();


	@BeforeClass
	public void openBrowser() {
		np.Initialization();
		np.landingPage();//Navigate to landing page

	}
	@Test
	public void clickAndVerify() {
		for(int i=0;i<5;i++) {
			np.clickOnButton();//click on button multiple times using for loop
			if(np.verifyMessage().contains("Action successful ")) {
				Assert.assertEquals("Action successful ",np.verifyMessage());
			}else if(np.verifyMessage().contains("Action unsuccesful, please try again "))
				Assert.assertEquals("Action unsuccesful, please try again ",np.verifyMessage());
		}
	}

	@AfterClass
	public void afterClass() {
		np.closeBrowser();//Close the Browser
	}
}
