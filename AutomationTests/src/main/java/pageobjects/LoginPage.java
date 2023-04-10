package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	 WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="username")
	  WebElement usernameElement;
	@FindBy(id="password")
	  WebElement passwordElement;
	@FindBy(xpath="//i[contains(text(),' Login')]")
	 WebElement login;
	@FindBy(xpath="//div[@id='flash']")
	 WebElement error;
	
	public WebElement getUsername() {
		return usernameElement;
	}

	public WebElement getPassword() {
		return passwordElement;
	}
	public WebElement getErrorMessage() {
		return error;
	}
	
	public void LogintoApp(String username, String password) {
		usernameElement.sendKeys(username);
		passwordElement.sendKeys(password);
		login.click();
	}
	
	

	    
}
