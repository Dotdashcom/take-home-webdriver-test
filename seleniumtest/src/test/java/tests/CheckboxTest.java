package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.GenericPage;
import pages.CheckboxPage;

public class CheckboxTest extends GenericPage {

	CheckboxPage checkboxPage;

	@BeforeMethod
	public void setup() {
		driver.get("http://localhost:7080/checkboxes");
		checkboxPage = new CheckboxPage();
	}

	@Test
	public void tcCheck() throws InterruptedException {
		Thread.sleep(2000);
		checkboxPage.checkBox1.click();
		Assert.assertTrue(checkboxPage.checkBox1.isSelected());
		Thread.sleep(2000);
		checkboxPage.checkBox1.click();
		Assert.assertFalse(checkboxPage.checkBox1.isSelected());
		Thread.sleep(2000);
		checkboxPage.checkBox2.click();
		Assert.assertFalse(checkboxPage.checkBox2.isSelected());
		Thread.sleep(2000);
		checkboxPage.checkBox2.click();
		Assert.assertTrue(checkboxPage.checkBox2.isSelected());
		Thread.sleep(2000);
	}

}