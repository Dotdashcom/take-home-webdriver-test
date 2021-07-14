package com.theInternetPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class CheckBoxesPage extends BasePage {

	WebDriver obj_Driver;;

	String checkboxTitle = "//h3[text()='Checkboxes']";
	String checkBox1 = "//input[@type='checkbox'][1]";
	String checkBox2 = "//input[@type='checkbox'][2]";

	public CheckBoxesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub

		this.obj_Driver = driver;

	}

	public void isDisplayedPage() {
		explicitWait(checkboxTitle);
		Assert.assertTrue(obj_Driver.findElements(By.xpath(checkboxTitle)).size() > 0, "Checkbox  page is displayed");
	}

	public void checkCheckBox1() {

		click(checkBox1, "checkbox 1");
		if (obj_Driver.findElement(By.xpath(checkBox1)).isSelected()) {
			Reporter.log("Checkbox1 is selected");
			Assert.assertTrue(true, "Checkbox1 is selected");
		}

	}

	public void checkCheckBox2() {

		click(checkBox2, "checkbox 2");
		if (obj_Driver.findElement(By.xpath(checkBox2)).isSelected()) {
			Reporter.log("Checkbox2 is selected");
			Assert.assertTrue(true, "Checkbox2 is selected");
		}
	}

	public void uncheckCheckBox1() {

		click(checkBox1, "checkbox 1");
		if (!obj_Driver.findElement(By.xpath(checkBox1)).isSelected()) {
			Reporter.log("Checkbox1 is unchecked");
			Assert.assertTrue(true, "Checkbox1 is unchecked");
		}

	}

	public void uncheckCheckBox2() {

		click(checkBox2, "checkbox 2");
		if (!obj_Driver.findElement(By.xpath(checkBox1)).isSelected()) {
			Reporter.log("Checkbox2 is unchecked");
			Assert.assertTrue(true, "Checkbox2 is unchecked");
		}
	}
}
