package com.dotdash.farhan;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginHomePageFactory {
	public LoginHomePageFactory(WebDriver driver) {
		driver = MainDriver.getDriver();
		PageFactory.initElements(driver,this); 
	}

	@FindBy(xpath = "//h2" )
	public static WebElement secureAreaTitle;

	@FindBy(xpath = "//a[@class='button secondary radius']" )
	public static WebElement logoutBtn;

	public WebElement secureAreaTitle() {
		return secureAreaTitle;
	}
	
	public WebElement logoutBtn() {
		return logoutBtn;
	}
}
