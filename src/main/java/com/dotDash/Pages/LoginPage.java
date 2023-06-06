package com.dotDash.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	//webElements
	@FindBy(xpath = "//input[@name='username']")
	WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement logInBtn;

	@FindBy(xpath = "//div//h4[contains(text(),'Welcome to the Secure Area. When you are done click logout below.')]")
	WebElement welcomMsg;

	// Login page error msg
	@FindBy(xpath = "//div[@class='large-12 columns']//div[@class='flash error']")
	WebElement loginErrormsg;

	// Initializing the PO
	public LoginPage(WebDriver driver) {
		this.driver=driver;
			PageFactory.initElements(driver, this);
	}

	// Login Page action methods

	public void loginToApp(String uname, String pwd)  {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		logInBtn.click();
		// close Browser Popup
		//closeBrowserPopUp();

	}

	public String verifyLandingPageTitile() {
		return welcomMsg.getText();
	}

	public void closeBrowserPopUp() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public String ValidateLognPageErrorMsg() {
		return loginErrormsg.getText().split("×")[0].trim();
		//return loginErrormsg.getText().trim();
		
	}

}
