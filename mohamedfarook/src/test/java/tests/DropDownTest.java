package tests;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.DropDownPage;

public class DropDownTest extends BaseClass {

	DropDownPage dropDownPageObj;

	@BeforeMethod
	public void launch() {
		initialize();
		driver.get("http://localhost:7080/dropdown");
		dropDownPageObj = new DropDownPage();
	}

	@Test
	public void dropDown1() throws InterruptedException {
		Select element = new Select(dropDownPageObj.dropDownElement);
		element.selectByVisibleText("Option 1");
		Thread.sleep(3000);
		Assert.assertEquals(element.getFirstSelectedOption().getText(), "Option 1");
	}

	@Test
	public void DropDownTest2() throws InterruptedException {
		Select element2 = new Select(dropDownPageObj.dropDownElement);
		element2.selectByVisibleText("Option 2");
		Thread.sleep(3000);
		Assert.assertEquals(element2.getFirstSelectedOption().getText(), "Option 2");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
