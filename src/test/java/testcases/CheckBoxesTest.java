package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CheckBoxesPage;
import testbase.TestBase;
import utilities.TestUtility;

public class CheckBoxesTest {
	WebDriver driver;
	CheckBoxesPage checkBoxesPage;

	@Test(priority = 1, description = "checkbox 1 is unselected bydefault")
	public void checkbox1isUnselected() throws IOException {
		WebElement checkbox1 = checkBoxesPage.getCheckBox1();
		Boolean ischeckBox1Unselected = checkbox1.isDisplayed() && !checkbox1.isSelected();
		Assert.assertTrue(ischeckBox1Unselected);
	}

	@Test(priority = 2, description = "checkbox 2 is selected by default")
	public void checkbox2isSelected() {
		WebElement checkbox2 = checkBoxesPage.getCheckBox2();
		Boolean ischeckBox2Selected = checkbox2.isDisplayed() && checkbox2.isSelected();
		Assert.assertTrue(ischeckBox2Selected);
	}

	@Test(priority = 3, description = "checkbox 1 can be selected and unselected")
	public void checkbox1selectedunselected() {
		WebElement checkbox1 = checkBoxesPage.getCheckBox1();

		TestUtility.selectCheckBox(checkbox1);
		Boolean ischeckBox1Selected = checkbox1.isSelected();
		Assert.assertTrue(ischeckBox1Selected);

		TestUtility.unselectCheckBox(checkbox1);
		Boolean ischeckBox1UnSelected = !checkbox1.isSelected();
		Assert.assertTrue(ischeckBox1UnSelected);
	}

	@Test(priority = 4, description = "checkbox 2 can be selected and unselected")
	public void checkbox2selectedunselected() {
		WebElement checkbox2 = checkBoxesPage.getCheckBox2();

		TestUtility.unselectCheckBox(checkbox2);
		Boolean ischeckBox2Unselected = !checkbox2.isSelected();
		Assert.assertTrue(ischeckBox2Unselected);

		TestUtility.selectCheckBox(checkbox2);
		Boolean ischeckBox2Selected = checkbox2.isSelected();
		Assert.assertTrue(ischeckBox2Selected);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = TestBase.getInstance();
		checkBoxesPage = new CheckBoxesPage(driver);
		checkBoxesPage.getUrl();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}