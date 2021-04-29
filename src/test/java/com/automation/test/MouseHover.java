package com.automation.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.automation.pageobject.IframePage;
import com.automation.pageobject.MouseHoverPage;

public class MouseHover extends BaseTest {
	@Test
	public void MouseHoverTest() throws InterruptedException  {
	
		driver.get(configProperties.getProperty("BaseUrl")+"/hovers");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		MouseHoverPage.validateMouseHovedrHeader(driver);
		Thread.sleep(2000);
		MouseHoverPage.MouseHover(driver);
		
		
		
	}

}
