package com.Pages;


import org.openqa.selenium.By;

public class LoginPage extends BaseClass {

	//
	By loginPageHeader=By.xpath("//div[@class='example']//h2");
	By userName= By.id("username");
	By password=By.id("password");
	By loginButton=By.cssSelector("button[type='submit']");
	By secureAreaHeader=By.cssSelector("h4[class='subheader']");
	By invalidUserText=By.id("flash");


	public String getLoginPageHeader() {
		return driver.findElement(loginPageHeader).getText();
	}

	public void loginCred(String un, String pwd)

	{
		driver.findElement(userName).sendKeys(un);	
		driver.findElement(password).sendKeys(pwd);	
		driver.findElement(loginButton).click();
	}
	public String getSecureHeaderText(){
		waitforElementLocated(secureAreaHeader);
		return driver.findElement(secureAreaHeader).getText();

	}
	public String getInvalidUserText(){
		waitforElementLocated(invalidUserText);
		return driver.findElement(invalidUserText).getText();

	}

}
