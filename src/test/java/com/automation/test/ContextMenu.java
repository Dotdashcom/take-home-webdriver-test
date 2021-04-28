package com.automation.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.automation.pageobject.CheckBoxsPage;
import com.automation.pageobject.ContextMenuPage;

public class ContextMenu extends BaseTest {
	
	@Test
	public void Checkboxes() {
		
		driver.get(configProperties.getProperty("BaseUrl")+"/context_menu");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ContextMenuPage.validateContextMenuHeader(driver);
		ContextMenuPage.clickContextMenuAndValidateText(driver);
	}
}
