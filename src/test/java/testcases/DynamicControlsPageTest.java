package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.DynamicControlsPage;
import testbase.TestBase;

public class DynamicControlsPageTest {

	WebDriver driver;
	DynamicControlsPage dynamicControlsPage;

	@Test(priority = 1, description = "Remove checkbox")
	public void removeCheckboxTest() {
		dynamicControlsPage.clickRemoveOrAddChkButton();
		String actualMessage = dynamicControlsPage.waitAndGetCheckBoxFormMessage();
		String expectedMessage = "It's gone!";
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	@Test(priority = 2, description = "Add checkbox")
	public void addCheckboxTest() {
		dynamicControlsPage.clickRemoveOrAddChkButton();
		dynamicControlsPage.waitAndGetCheckBoxFormMessage();
		dynamicControlsPage.clickRemoveOrAddChkButton();
		String actualMessage = dynamicControlsPage.waitAndGetCheckBoxFormMessage();
		String expectedMessage = "It's back!";
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	@Test(priority = 3, description = "Enable input field")
	public void enableInputTest() {
		dynamicControlsPage.clickDisableOrEnableButton();
		String actualMessage = dynamicControlsPage.waitAndGetInputFormMessage();
		String expectedMessage = "It's enabled!";
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	@Test(priority = 4, description = "Disable input field ")
	public void disableInputTest() {
		dynamicControlsPage.clickDisableOrEnableButton();
		dynamicControlsPage.waitAndGetInputFormMessage();
		dynamicControlsPage.clickDisableOrEnableButton();
		String actualMessage = dynamicControlsPage.waitAndGetInputFormMessage();
		String expectedMessage = "It's disabled!";
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = TestBase.getInstance();
		dynamicControlsPage = new DynamicControlsPage(driver);
		dynamicControlsPage.getUrl();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
