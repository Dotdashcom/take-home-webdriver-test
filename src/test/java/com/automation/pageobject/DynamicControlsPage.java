package com.automation.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicControlsPage {
	public static final By DYNAMICCONTROLSHEADER=By.xpath("//h4[text()='Dynamic Controls']");
	public static final By REMOVE_BTN=By.xpath("//button[text()='Remove']");
	public static final By CHECKBOX=By.id("checkbox");
	public static final By ADD_BTN=By.xpath("//button[text()='Add']");
	public static final By GONE_MSG=By.xpath("//p[contains(text(),'gone!')]");
	public static final By ENABLE_BTN=By.xpath("//button[text()='Enable']");
	public static final By TEXT_BOX=By.xpath("//input[@type='text']");
	public static final By DISABLED_BTN=By.xpath("//button[text()='Disable']");
	
	
	
	
	
	
	
	public static void validateDynamicControlsHeader(WebDriver driver) {
		WebElement element= driver.findElement(DYNAMICCONTROLSHEADER);
		Assert.assertTrue(element.isDisplayed(), "Dynamic Controls Header is not Displaying");

	}
	
	public static void removeCheckBox(WebDriver driver) {
		 driver.findElement(REMOVE_BTN).click();
		 WebDriverWait wait=new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(CHECKBOX));
		 Assert.assertTrue(driver.findElements(CHECKBOX).size()<=0, "check box is not remove");
			
	}
	
	public static void addCheckBox(WebDriver driver) {
		
		 driver.findElement(ADD_BTN).click();
		 WebDriverWait wait=new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKBOX));
		 Assert.assertTrue(driver.findElement(CHECKBOX).isDisplayed(), "check box is not displayed");
			
	}
	
	public static void textBoxEnable(WebDriver driver) {
		driver.findElement(ENABLE_BTN).click();
		 WebDriverWait wait=new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(ENABLE_BTN));
		 Assert.assertTrue(driver.findElement(TEXT_BOX).isEnabled(), "Input box is not enabled");
	}
	
	public static void textBoxDisabled(WebDriver driver) {
		driver.findElement(DISABLED_BTN).click();
		 WebDriverWait wait=new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(DISABLED_BTN));
		 Assert.assertFalse(driver.findElement(TEXT_BOX).isEnabled(), "Input box is not disableds");
	}
	

}
