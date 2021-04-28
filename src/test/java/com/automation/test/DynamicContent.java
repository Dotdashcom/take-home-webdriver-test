package com.automation.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.automation.pageobject.DropDownPage;
import com.automation.pageobject.DynamicContentPage;

public class DynamicContent extends BaseTest {
	
	@Test
	public void DropDownTest() throws InterruptedException  {
		//driver.get("http://localhost:7080/login");
		driver.get(configProperties.getProperty("BaseUrl")+"/dynamic_content");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		DynamicContentPage.validateDynamicContentHeader(driver);
		
		DynamicContentPage.refreshContentAndValidate(driver);
	
		
	}


}
