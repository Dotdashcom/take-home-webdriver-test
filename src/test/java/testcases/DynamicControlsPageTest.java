package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.DynamicControlsPage;
import baseTest.AbstractE2E;

public class DynamicControlsPageTest {

	WebDriver driver;
	DynamicControlsPage dynamicControlsPage;

	@Test(description = "Remove checkbox")
	public void TC01_removeCheckboxTest_success() {
		dynamicControlsPage.clickRemoveOrAddChkButton();
		String actualMessage = dynamicControlsPage.waitAndGetCheckBoxFormMessage();
		String expectedMessage = "It's gone!";
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	@Test(description = "Add checkbox")
	public void TC02_addCheckboxTest_success() {
		dynamicControlsPage.clickRemoveOrAddChkButton();
		dynamicControlsPage.waitAndGetCheckBoxFormMessage();
		dynamicControlsPage.clickRemoveOrAddChkButton();
		String actualMessage = dynamicControlsPage.waitAndGetCheckBoxFormMessage();
		String expectedMessage = "It's back!";
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	@Test(description = "Enable input field")
	public void TC03_enableInputTest_success() {
		dynamicControlsPage.clickDisableOrEnableButton();
		String actualMessage = dynamicControlsPage.waitAndGetInputFormMessage();
		String expectedMessage = "It's enabled!";
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	@Test(description = "Disable input field ")
	public void TC04_disableInputTest_success() {
		dynamicControlsPage.clickDisableOrEnableButton();
		dynamicControlsPage.waitAndGetInputFormMessage();
		dynamicControlsPage.clickDisableOrEnableButton();
		String actualMessage = dynamicControlsPage.waitAndGetInputFormMessage();
		String expectedMessage = "It's disabled!";
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = AbstractE2E.getInstance();
		dynamicControlsPage = new DynamicControlsPage(driver);
		dynamicControlsPage.getUrl();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
