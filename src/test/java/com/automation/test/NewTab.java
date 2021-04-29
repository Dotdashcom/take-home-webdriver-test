package com.automation.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.automation.pageobject.MouseHoverPage;
import com.automation.pageobject.NewTabPage;

public class NewTab  extends BaseTest{
	@Test
	public void NewTabTest() throws InterruptedException  {
	
		driver.get(configProperties.getProperty("BaseUrl")+"/windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		NewTabPage.validateNewWindowHeader(driver);
		NewTabPage.clickHereAndValidateNewWindow(driver);
		
		
		
	}
}
