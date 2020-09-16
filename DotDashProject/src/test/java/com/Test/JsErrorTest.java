package com.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.dotDashBase;
import com.POM.JSErrorPage;

public class JsErrorTest  extends dotDashBase{
	public WebDriver driver;

	@BeforeTest
	public void Driver() throws InterruptedException {

		driver = setupDriver();
		driver.get("http://localhost:7080/javascript_error");//to launch the browser
	}

	@Test
	public void errors() {
		JSErrorPage error = new JSErrorPage(driver);
		error.JSErrors();

	}

	@AfterTest
	public void quit() {
		//driver.close();
		driver.quit();
	}
}

