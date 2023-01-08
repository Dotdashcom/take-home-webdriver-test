package com.theInternet.qa.pages;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;
	Logger log = LogManager.getLogger("Loginpage");

	@FindBy(id = "username")
	WebElement UserName;

	@FindBy(xpath = "//input[@name='password']")
	WebElement PassWord;

	@FindBy(xpath = ("//button[@type='submit']"))
	WebElement Login_button;

	@FindBy(xpath = ("//h4[@class='subheader']"))
	WebElement LoginConfir_msg;

	@FindBy(id = "flash")
	WebElement Error_msg;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Verify_Login_Success() {
		UserName.sendKeys("tomsmith");
		PassWord.sendKeys("SuperSecretPassword!");
		Login_button.click();
		String Secure_Area_Message = LoginConfir_msg.getText();
		// Validating the Test_Login_Success by comparing Secure_Area_Message with the
		// expected Message
		Assert.assertEquals(Secure_Area_Message, "Welcome to the Secure Area. When you are done click logout below.");
		log.info("Login successful with given credentials");
	}

	public void Verify_Login_Failure() {
		UserName.sendKeys("WrongUsername");
		PassWord.sendKeys("WrongPassword");
		Login_button.click();
		String Error_Message = Error_msg.getText();
		Assert.assertTrue(Error_Message.contains("Your username is invalid!"));
		log.info("Login not successful with given credentials");
	}

}
