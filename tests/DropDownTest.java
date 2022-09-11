package tests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Util.TestBase;
import graphql.Assert;
import pages.DropDownPage;

public class DropDownTest extends TestBase {
	DropDownPage dp=new DropDownPage();
	
	@BeforeClass
	public void OpenBrowser() {
		dp.Initialization();
		dp.LandingPage();
	}
	@Test
	public void dropDownTest1() {
		Assert.assertTrue(dp.selectDropDown1().equals("Option 1"));//verify option 1 is selected
		
	}
	@Test
	public void dropDownTest2() {
		dp.selectDropDown2();
		Assert.assertTrue(dp.selectDropDown2().equals("Option 2"));	//verify option 2 is selected
	}

	@AfterClass
	public void afterClass() {
		dp.closeBrowser();
	}
}
