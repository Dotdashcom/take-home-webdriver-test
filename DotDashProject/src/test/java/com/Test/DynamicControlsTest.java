package com.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.dotDashBase;
import com.POM.DynamicControlsPage;

public class DynamicControlsTest extends dotDashBase{
	public WebDriver driver;

	@BeforeTest
	public void Driver() throws InterruptedException {

		driver = setupDriver();
		driver.get("http://localhost:7080/dynamic_controls");//to launch the browser
	}

	@Test
	public void dynamicControls() {
		DynamicControlsPage dynamic =  new DynamicControlsPage(driver);
		dynamic.dynamic();
	}
	@AfterTest
	public void quit() {
		//driver.close();
		driver.quit();
	}
}
