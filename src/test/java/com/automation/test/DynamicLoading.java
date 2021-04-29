package com.automation.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.automation.pageobject.DynamicControlsPage;
import com.automation.pageobject.DynamicLoadingPage;

public class DynamicLoading extends BaseTest {

	@Test
	public void DynamicLoadingTest() throws InterruptedException  {
		//driver.get("http://localhost:7080/login");
		driver.get(configProperties.getProperty("BaseUrl")+"/dynamic_loading/2");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		DynamicLoadingPage.validateDynamicLoadingsHeader(driver);
		DynamicLoadingPage.clickStartButttonAndValidateText(driver);
		
		
	}
	
}
