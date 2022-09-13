package tests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Util.TestBase;
import pages.DynamicControlsPage;

public class DynamicControlsTest extends TestBase{
	DynamicControlsPage dp=new DynamicControlsPage();
	

	@BeforeClass
	public void openBrowser() {
		dp.Initialization();
		dp.landingPage();//Navigate to landing page
		
	}
	@Test
	public void verifyCheckBoxRemoved() {
		dp.removeCheckBox();//click on remove button
		Assert.assertTrue(dp.VerifyCheckBoxRemoved().contains("It's gone!"));//verify checkbox is gone
	
	}
	@Test(dependsOnMethods="verifyCheckBoxRemoved")
	public void verifyCheckBoxPresent() {
		dp.clickOnAdd();//click on add button
		Assert.assertTrue(dp.VerifyCheckBoxPresent().contains("It's back!"));//verify checkbox is back

	}
	@Test(dependsOnMethods="verifyCheckBoxPresent")
	public void verifyTextBoxEnabled() {
		dp.clickOnEnable();//click on Enable button
		Assert.assertTrue(dp.VerifyTextBoxEnabled().contains("It's enabled!"));//verify textbox is enabled

	}
	@Test(dependsOnMethods="verifyTextBoxEnabled")
	public void clickOnDisable() {
		dp.clickOnDisable();//click on disable button
		Assert.assertTrue(dp.VerifyTextBoxDisabled().contains("It's disabled!"));//verify textbox is disabled
	}

	@AfterClass
	public void afterClass() {
		dp.closeBrowser();//Close the Browser
	}


}
