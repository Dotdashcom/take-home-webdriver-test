package com.company.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//This class with store all the locators and method of class
public class LoginPage {
	
	WebDriver driver;
	
	By username=By.xpath("//*[@id=\"username\"]");
	By password=By.xpath("//*[@id=\"password\"]");
	By login_button=By.xpath("//*[@id=\"login\"]/button");
	By logout_button=By.xpath("//*[@id=\"content\"]/div/a");
	By Message=By.xpath("/html/body/div[1]/div/div");
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	public void typeUsername()
	{
		driver.findElement(username).sendKeys("fff");
		
	}
	public void typePassword()
	{
		driver.findElement(password).sendKeys("SuperSecretPassword!");
		
	}
	public WebElement getTextMessage() {
		return driver.findElement(Message);
	}
	public void clickonLoginButton()
	{
		driver.findElement(login_button).click();
		
	}
	public void clickonLogout()
	{
		driver.findElement(logout_button).click();
		
	}
}
