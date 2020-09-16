package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFailPage {

	public WebDriver driver;
	String loginKey;

	public LoginFailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// paageObjectModel using selenium pagefactory

	}


	@FindBy(xpath = "//input[@id='username']")
	WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//button[@class='radius']")
	WebElement login;

	@FindBy(xpath = "//div[@id='flash']") //print the text
	WebElement txt;


	String loginfailure;
	public void loginTest(String name, String password){
		this.username.sendKeys(name);
		this.password.sendKeys(password);
		login.click();

	}
}
