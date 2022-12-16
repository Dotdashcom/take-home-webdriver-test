package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.CheckboxPage;

public class CheckboxTest extends BaseClass {

	CheckboxPage checkObj;

	public CheckboxTest() {
		super();
	}

	@BeforeMethod
	public void launch() {
		initialize();
		driver.get("http://localhost:7080/checkboxes");
		checkObj = new CheckboxPage();
	}

	@Test(priority = 1)
	public void checkBoxCheck1() throws InterruptedException {
		Thread.sleep(3000);
		checkObj.checkBox1.click();
		Assert.assertTrue(checkObj.checkBox1.isSelected());
		Thread.sleep(3000);
		checkObj.checkBox1.click();
		Assert.assertFalse(checkObj.checkBox1.isSelected());

	}

	@Test(priority = 2)
	public void checkBoxCheck2() throws InterruptedException {
		Thread.sleep(3000);
		checkObj.checkBox2.click();
		Assert.assertFalse(checkObj.checkBox2.isSelected());
		Thread.sleep(3000);
		checkObj.checkBox2.click();
		Assert.assertTrue(checkObj.checkBox2.isSelected());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
