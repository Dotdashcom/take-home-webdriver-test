package com.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.dotDashBase;
import com.POM.FloatingMenu;

public class FloatingMenuTest extends dotDashBase {
	public WebDriver driver;

	@BeforeTest
	public void Driver() throws InterruptedException {

		driver = setupDriver();
		driver.get("http://localhost:7080/floating_menu");//to launch the browser
	}

	@Test
	public void menu(){
		FloatingMenu menu = new FloatingMenu(driver);
		menu.Menu();
	}
	@AfterTest
	public void quit() {
		//driver.close();
		driver.quit();
	}
}
