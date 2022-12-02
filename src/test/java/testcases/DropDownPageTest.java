package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.DropDownPage;
import testbase.TestBase;

public class DropDownPageTest {

	WebDriver driver;
	DropDownPage dropDownPage;

	@Test(priority = 1, description = "select Options of Drop Down")
	public void DropDownTestoptions() {
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
		driver = TestBase.getInstance();
		dropDownPage = new DropDownPage(driver);
		dropDownPage.getUrl();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
