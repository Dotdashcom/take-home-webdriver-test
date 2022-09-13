package tests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Util.TestBase;
import pages.DynamicLoadingPage;


public class DynamicLoadingTest extends TestBase {

	DynamicLoadingPage dp=new DynamicLoadingPage();
	
	@BeforeClass
	public void openBrowser() {
		dp.Initialization();
		dp.landingPage();//Navigate to landing page

	}
	@Test(priority=1)
	public void VerifyHelloWorld() {
		dp.clickonStart();//click on start button
		Assert.assertTrue(dp.VerifyText().contains("Hello World!"));//Verify text Hello World is displayed
	}
	@AfterClass
	public void afterClass() {
		dp.closeBrowser();//Close the Browser
	}

}
