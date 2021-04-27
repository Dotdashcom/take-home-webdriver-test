package com.automation.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {
	public static final By LOGINHEADER= By.xpath("//h2[text()='Login Page']");
	public static final By LOGINID= By.id("username");
	public static final By LOGINPW= By.id("password");
	public static final By SUBMIT=By.xpath("//button/i[contains(text(),'Login')]");
	public static final By LOGEDINMSG=By.xpath("//div[contains(text(),'You logged into a secure area!')]");
	public static final By USERNAME_INVALID_MSG=By.xpath("//div[contains(text(),'Your username is invalid!')]");
	
	public static void validateLoginHeader(WebDriver driver) {
		WebElement element= driver.findElement(LOGINHEADER);
		Assert.assertTrue(element.isDisplayed(), "LoginHeader is not Displaying");
	
	} 
	public static void Login(WebDriver driver,String loginid, String loginpw) {
		if(!("".equals(loginid))) {
			driver.findElement(LOGINID).sendKeys(loginid);
		}
		if(!("".equals(loginpw))) {
			driver.findElement(LOGINPW).sendKeys(loginpw);
		}
		driver.findElement(SUBMIT).click();
	}
	public static void validateLogedinMSG(WebDriver driver) {
		WebElement element= driver.findElement(LOGEDINMSG);
		Assert.assertTrue(element.isDisplayed(), "LoginedMSG is not Displaying");
	
	} 
	public static void validateUserNameInvalidMSG(WebDriver driver) {
		WebElement element= driver.findElement(USERNAME_INVALID_MSG);
		Assert.assertTrue(element.isDisplayed(), "User Name invalid MSG is not Displaying");
	
	} 
	
	
	
	
}
