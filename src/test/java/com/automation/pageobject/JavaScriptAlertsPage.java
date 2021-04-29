package com.automation.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class JavaScriptAlertsPage {
	
	public static final By JAVASCRIPTALERTHEADER=By.xpath("//h3[text()='JavaScript Alerts']");
	public static final By JAVASCRIPTALERT=By.xpath("//button[text()='Click for JS Alert']");
	public static final By JSCONFIRM=By.xpath("//button[text()='Click for JS Confirm']");
	public static final By JSPROMPT=By.xpath("//button[text()='Click for JS Prompt']");
	public static final By ALERTMESSAGE= By.xpath("//p[@id='result']");


	public static void validateJavaScriptAlertHeader(WebDriver driver) {
		WebElement element= driver.findElement(JAVASCRIPTALERTHEADER);
		Assert.assertTrue(element.isDisplayed(), "Java Script Alert Header is not Displaying");
	}
	
	
	
	public static void javaScriptAlertMsg(WebDriver driver) {
		driver.findElement(JAVASCRIPTALERT).click();
		
		driver.switchTo().alert().accept();
		Assert.assertEquals(driver.findElement(ALERTMESSAGE).getText(), "You successfuly clicked an alert");
	}
	
	public static void jsConfirmButton(WebDriver driver) {
		driver.findElement(JSCONFIRM).click();
		driver.switchTo().alert().accept();
		Assert.assertEquals(driver.findElement(ALERTMESSAGE).getText(), "You clicked: Ok");
	}
	
	public static void jsPromptButton(WebDriver driver,String msg) {
		driver.findElement(JSPROMPT).click();
		driver.switchTo().alert().sendKeys(msg);
		driver.switchTo().alert().accept();
		Assert.assertEquals(driver.findElement(ALERTMESSAGE).getText(), "You entered: "+msg);
	}

}
