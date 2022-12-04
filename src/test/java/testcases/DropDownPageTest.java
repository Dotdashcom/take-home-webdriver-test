package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.DropDownPage;
import baseTest.AbstractE2E;

public class DropDownPageTest {

	WebDriver driver;
	DropDownPage dropDownPage;

	@Test(description = "select Options of Drop Down")
	public void TC01_DropDownTestOptions_success() {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(dropDownPage.getSelectedOption(), "Please select an option");
		dropDownPage.selectOptionByVisibleText("Option 1");
		softAssert.assertEquals(dropDownPage.getSelectedOption(), "Option 1");
		dropDownPage.selectOptionByVisibleText("Option 2");
		softAssert.assertEquals(dropDownPage.getSelectedOption(), "Option 2");
		softAssert.assertAll();
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = AbstractE2E.getInstance();
		dropDownPage = new DropDownPage(driver);
		dropDownPage.getUrl();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
