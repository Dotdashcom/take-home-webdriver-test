package com.TakeHomeTest.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {

	WebDriver ldriver;
	public static String trim_msg;
	
	@FindBy(id="username")
	private WebElement Username;
	
	@FindBy(id="password")
	private WebElement Password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement Login;
	
	@FindBy(xpath="//div/h2")
	public WebElement Login_message;
	
	//@FindBy(xpath="//div/h2")
	//private WebElement Failure_message;
	
	@FindBy(xpath="//i[@class='icon-2x icon-signout']")
	private WebElement Logout;
	
	public LoginPageObjects(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	public void Enter_username() {
		Username.sendKeys("tomsmith");
	}
	
	public void Enter_password() {
		Password.sendKeys("SuperSecretPassword!");
	}
	
	public void Press_Login() {
		Login.click();
	}
	
	public void Success_login_msg() {
		String success_message=Login_message.getText();
		System.out.println(success_message);
	}
	
	public void Click_Logout() {
		Logout.click();
	}
	
	public void Enter_invalidusername() {
		Username.sendKeys("Tom");
	}
	
	public void Enter_invalidpwd() {
		Password.sendKeys("password");
	}
	
	public void Failed_login() {
		Login.click();
	}
	public void returnedToLogin() {
		String returnedLogin=Login_message.getText();
		System.out.println(returnedLogin);
	}
	/*public void Failed_msg() {
		String fail_msg=Failure_message.getText();
        trim_msg=fail_msg.substring(0, fail_msg.length() - 1);

		System.out.println(trim_msg);
	}*/
}
