package com.automation.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicLoadingPage {
	public static final By DYNAMICLOADINGHEADER=By.xpath("//h3[text()='Dynamically Loaded Page Elements']");
	public static final By START_BTN=By.xpath("//button[text()='Start']");
	public static final By TEXT_MSG=By.xpath("//div[@id='finish']/h4");
	
	
	
	public static void validateDynamicLoadingsHeader(WebDriver driver) {
		WebElement element= driver.findElement(DYNAMICLOADINGHEADER);
		Assert.assertTrue(element.isDisplayed(), "Dynamic Loading Header is not Displaying");

	}
	
	public static void clickStartButttonAndValidateText(WebDriver driver) {
		 driver.findElement(START_BTN).click();
		 WebDriverWait wait=new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(TEXT_MSG));
		 Assert.assertEquals(driver.findElement(TEXT_MSG).getText(), "Hello World!");
	}

}
