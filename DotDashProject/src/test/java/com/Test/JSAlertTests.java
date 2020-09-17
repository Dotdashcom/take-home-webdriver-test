package com.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.dotDashBase;
import com.POM.JSAlertsPage;

public class JSAlertTests extends dotDashBase {
	public WebDriver driver;

	@BeforeTest
	public void Driver() throws InterruptedException {

		driver = setupDriver();
		driver.get("http://localhost:7080/javascript_alerts");//to launch the browser
	}

	@Test
	public void alert() throws InterruptedException{
		JSAlertsPage alert = new JSAlertsPage(driver);
		alert.Alerts();
	}

	@AfterTest
	public void quit() {
		//driver.close();
		driver.quit();
	}
}
