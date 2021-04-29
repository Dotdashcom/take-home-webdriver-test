package com.automation.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.automation.pageobject.FileUploadPage;
import com.automation.pageobject.FloatingMenuPage;

public class FloatingMenu extends BaseTest {
	@Test
	public void FloatingMenuTest() throws InterruptedException  {
	
		driver.get(configProperties.getProperty("BaseUrl")+"/floating_menu");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		FloatingMenuPage.validateFloatingMenuHeader(driver);
		FloatingMenuPage.scrollAndValidateFloatingMenus(driver);
		
		
		
	}

}
