package com.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.dotDashBase;
import com.POM.DropDownPage;

public class DropDownTest extends dotDashBase {
	WebDriver driver;


	@BeforeTest
	public void Driver() throws InterruptedException {

		driver = setupDriver();
		driver.get("http://localhost:7080/dropdown");//to launch the browser
	}


	@Test
	public void dropDownTest(){

		DropDownPage dd = new DropDownPage(driver);
		dd.dropdown();

		Assert.assertEquals(dd.dropdown(), "Option 1");

	}
	@AfterTest
	public void quit() {
		//driver.close();
		driver.quit();
	}
}
