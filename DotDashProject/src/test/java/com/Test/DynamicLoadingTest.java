package com.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.dotDashBase;
import com.POM.DynamicControlsPage;
import com.POM.DynamicLoadingPage;

public class DynamicLoadingTest extends dotDashBase {
	public WebDriver driver;

	@BeforeTest
	public void Driver() throws InterruptedException {

		driver = setupDriver();
		driver.get("http://localhost:7080/dynamic_loading/2");//to launch the browser
	}

	@Test
	public void dynamicControls() {
		DynamicLoadingPage dynamic =  new DynamicLoadingPage(driver);
		dynamic.dynamic();
	}
	@AfterTest
	public void quit() {
		//driver.close();
		driver.quit();
	}
}
