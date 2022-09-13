package tests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Util.TestBase;
import pages.FloatingMenuPage;

public class FloatingMenuTest extends TestBase{
	FloatingMenuPage fp=new FloatingMenuPage();
	
	@BeforeClass
	public void openBrowser() {
		
		fp.Initialization();
		fp.landingPage();//Navigate to LandingPage
			
	}
	@Test
	public void ScrollWindow() {
		fp.ValidateMenuPresent();//Verify Menu is Present
		fp.scrollDown();//Scrolls the Page
		Assert.assertTrue(fp.ValidateMenuPresent());//Verify Menu is still Present after Scrolling
	}

	@AfterClass
	public void afterClass() {
		fp.closeBrowser();//Close the Browser
	}
}
