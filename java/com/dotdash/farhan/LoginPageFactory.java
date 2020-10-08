package com.dotdash.farhan;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPageFactory {
	public LoginPageFactory(WebDriver driver) {
		driver = MainDriver.getDriver();
		PageFactory.initElements(driver,this); 
	}
	
	@FindBy(xpath = "//input[@id='username']" )
	public static WebElement username;
	
	@FindBy(xpath = "//input[@id='password']" )
	public static WebElement password;
	
	@FindBy(xpath = "//i[@class='fa fa-2x fa-sign-in']" )
	public static WebElement submitBtn;
	
	@FindBy(xpath="//h4[@class='subheader']")
	public static WebElement invalidInput;
	
	
	public WebElement username() {
		return username;
	}
	public WebElement password() {
		return password;
	}
	public WebElement submitBtn() {
		return submitBtn;
	}
	public WebElement invalidInput() {
		return invalidInput;
	}
}
