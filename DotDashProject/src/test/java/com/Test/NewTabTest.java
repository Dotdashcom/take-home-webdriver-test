package com.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.dotDashBase;
import com.POM.NewTabPage;

public class NewTabTest extends dotDashBase {
	public WebDriver driver;

	@BeforeTest
	public void Driver() throws InterruptedException {

		driver = setupDriver();
		driver.get("http://localhost:7080/windows");//to launch the browser
	}

	@Test
	public void tab(){
		NewTabPage tab = new NewTabPage(driver);
		tab.newtab();
		// Assert.assertEquals(tab.newTab(), "http://localhost:7080/windows/new");
	}

	@AfterTest
	public void quit() {
		//driver.close();
		driver.quit();
	}
}
