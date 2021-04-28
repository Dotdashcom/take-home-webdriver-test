package com.automation.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.automation.pageobject.DropDownPage;
import com.automation.pageobject.LoginPage;

public class DropDown extends BaseTest {
	
	@Test
	public void DropDownTest() throws InterruptedException  {
		//driver.get("http://localhost:7080/login");
		driver.get(configProperties.getProperty("BaseUrl")+"/dropdown");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		DropDownPage.validateDropDownHeader(driver);
		
		DropDownPage.selectDropDown(driver, "Option 1");
		DropDownPage.selectDropDown(driver, "Option 2");
		
	}

}
