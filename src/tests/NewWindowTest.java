package tests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Util.TestBase;
import pages.NewWindowPage;

public class NewWindowTest extends TestBase{
	NewWindowPage np=new NewWindowPage();
	
	
	@BeforeClass
	public void openBrowser() {
	np.Initialization();
	np.landingPage();//Navigate to landing page
	}
	
	@Test(priority=1) 
	public void verifyNewWindowText() {
		np.clickOnLink();//click on the click here link
		Assert.assertTrue(np.verifyText().contains("New Window"));//verify new opened tab has text new window
	}
	@AfterClass
	public void afterClass() {
		np.closeBrowser();//Close the Browser
	}
}
