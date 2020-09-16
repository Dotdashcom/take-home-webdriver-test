package com.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Base.dotDashBase;
import com.POM.FloatingMenu;
import com.POM.IFramePage;

public class IFrameTest extends dotDashBase {
	public WebDriver driver;

	@BeforeTest
	public void Driver() throws InterruptedException {

		driver = setupDriver();
		driver.get("http://localhost:7080/iframe");;//to launch the browser
	}

	@Test
	public void menu(){
		IFramePage frame = new IFramePage(driver);
		frame.iFrame();
		//this will check if i am in the iframe or not and give you the text that is present in the iframe.
		Assert.assertEquals(frame.Bodytext(), "Your content goes here.");
	}

	@AfterTest
	public void quit() {
		//driver.close();
		driver.quit();
	}
}
