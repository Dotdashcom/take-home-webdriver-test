package com.automation.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.automation.pageobject.DragandDropPage;
import com.automation.pageobject.LoginPage;

public class DragandDrop extends BaseTest {
	
	@Test
	public void DragDrop() {
		//driver.get("http://localhost:7080/login");
		driver.get(configProperties.getProperty("BaseUrl")+"/drag_and_drop");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		DragandDropPage.validateDragAndDropHeader(driver);
		DragandDropPage.DragAndDropAction(driver);
	
	}

}
