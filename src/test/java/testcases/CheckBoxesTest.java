package testcases;

import java.io.IOException;

import baseTest.AbstractE2E;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CheckBoxesPage;
import utilities.TestHandler;

public class CheckBoxesTest {
	WebDriver driver;
	CheckBoxesPage checkBoxesPage;

	@Test(description = "checkbox 1 is unselected bydefault")
	public void TC01_checkbox1isUnselected_success() throws IOException {
		WebElement checkbox1 = checkBoxesPage.getCheckBox1();
		Boolean ischeckBox1Unselected = checkbox1.isDisplayed() && !checkbox1.isSelected();
		Assert.assertTrue(ischeckBox1Unselected);
	}

	@Test(description = "checkbox 2 is selected by default")
	public void TC02_checkbox2isSelected_success() {
		WebElement checkbox2 = checkBoxesPage.getCheckBox2();
		Boolean ischeckBox2Selected = checkbox2.isDisplayed() && checkbox2.isSelected();
		Assert.assertTrue(ischeckBox2Selected);
	}

	@Test(description = "checkbox 1 can be selected and unselected")
	public void TC03_checkbox1selectedunselected_success() {
		WebElement checkbox1 = checkBoxesPage.getCheckBox1();

		TestHandler.selectCheckBox(checkbox1);
		Boolean ischeckBox1Selected = checkbox1.isSelected();
		Assert.assertTrue(ischeckBox1Selected);

		TestHandler.unselectCheckBox(checkbox1);
		Boolean ischeckBox1UnSelected = !checkbox1.isSelected();
		Assert.assertTrue(ischeckBox1UnSelected);
	}

	@Test(description = "checkbox 2 can be selected and unselected")
	public void TC04_checkbox2selectedunselected_success() {
		WebElement checkbox2 = checkBoxesPage.getCheckBox2();

		TestHandler.unselectCheckBox(checkbox2);
		Boolean ischeckBox2Unselected = !checkbox2.isSelected();
		Assert.assertTrue(ischeckBox2Unselected);

		TestHandler.selectCheckBox(checkbox2);
		Boolean ischeckBox2Selected = checkbox2.isSelected();
		Assert.assertTrue(ischeckBox2Selected);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = AbstractE2E.getInstance();
		checkBoxesPage = new CheckBoxesPage(driver);
		checkBoxesPage.getUrl();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}