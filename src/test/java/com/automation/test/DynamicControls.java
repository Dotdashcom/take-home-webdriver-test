package com.automation.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.automation.pageobject.DynamicContentPage;
import com.automation.pageobject.DynamicControlsPage;

public class DynamicControls extends BaseTest {
	
	@Test
	public void DynamicControlTest() throws InterruptedException  {
		//driver.get("http://localhost:7080/login");
		driver.get(configProperties.getProperty("BaseUrl")+"/dynamic_controls");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		DynamicControlsPage.validateDynamicControlsHeader(driver);
		DynamicControlsPage.removeCheckBox(driver);
		DynamicControlsPage.addCheckBox(driver);
		DynamicControlsPage.textBoxEnable(driver);
		DynamicControlsPage.textBoxDisabled(driver);
		
		
	}

}
