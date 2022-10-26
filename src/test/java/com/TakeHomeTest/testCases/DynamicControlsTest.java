package com.TakeHomeTest.testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.TakeHomeTest.pageObjects.DynamicControlsPageObjects;

public class DynamicControlsTest extends BaseClass{

	@Test
		public void dynamic_checkbox() {
		DynamicControlsPageObjects dynpage=new DynamicControlsPageObjects(driver);
		driver.get(url+"/dynamic_controls");
			dynpage.CheckBoxAddRemoveButton.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			String gonemessage=wait.until(ExpectedConditions.visibilityOf(dynpage.checkboxmessage)).getText();
			Assert.assertEquals(gonemessage, "It's gone!");
		
			dynpage.CheckBoxAddRemoveButton.click();
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));

			String addmessage=wait1.until(ExpectedConditions.visibilityOf(dynpage.checkboxmessage)).getText();
			Assert.assertEquals(addmessage, "It's back!");
		}
		
	@Test
	public void dynamic_textbox() {
		DynamicControlsPageObjects dynpage=new DynamicControlsPageObjects(driver);
		driver.get("http://localhost:7080/dynamic_controls");
			dynpage.TextBoxEnableDisableButton.click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			String enabledmessage=wait.until(ExpectedConditions.visibilityOf(dynpage.checkboxmessage)).getText();
			Assert.assertEquals(enabledmessage, "It's enabled!");
			
			dynpage.TextBoxEnableDisableButton.click();
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));

			String disabledmessage=wait1.until(ExpectedConditions.visibilityOf(dynpage.checkboxmessage)).getText();
			Assert.assertEquals(disabledmessage, "It's disabled!");
	}
}
