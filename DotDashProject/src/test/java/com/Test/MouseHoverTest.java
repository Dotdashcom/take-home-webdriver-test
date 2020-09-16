package com.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.dotDashBase;
import com.POM.MouseHoverPage;

public class MouseHoverTest extends dotDashBase {
	public WebDriver driver;

	@BeforeTest
	public void Driver() throws InterruptedException {

		driver = setupDriver();
		driver.get("http://localhost:7080/hovers");//to launch the browser
	}

	@Test
	public void MouseHover() {
		MouseHoverPage hover = new MouseHoverPage(driver);
		hover.PerformMouseHover();
	}

	@AfterTest
	public void quit() {
		//driver.close();
		driver.quit();
	}
}
