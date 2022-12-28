package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.GenericPage;
import pages.DropDownPage;

public class DropDownTest extends GenericPage {

	DropDownPage dropDownPage;

	@BeforeMethod
	public void setup() {
		driver.get("http://localhost:7080/dropdown");
		dropDownPage = new DropDownPage();
	}

	@Test
	public void tcDropDown() throws InterruptedException {
		Assert.assertEquals(dropDownPage.selectDropDown("Option 1"), "Option 1");
		Thread.sleep(2000);
		
		Assert.assertEquals(dropDownPage.selectDropDown("Option 2"), "Option 2");
		Thread.sleep(2000);
	}
}