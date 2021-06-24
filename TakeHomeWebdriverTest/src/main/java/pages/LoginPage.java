package pages;

import org.openqa.selenium.By;

import testBase.TestBase;

public class LoginPage extends TestBase {
	
	//Login Page Elements
	By userNameInputField = By.name("username");
	By passwordInputField = By.name("password");
	By loginBtn = By.xpath("//i[contains(text(),'Login')]");

	
	//Login Page Functions
	public void inputUsername(String username)	{
		driver.findElement(userNameInputField).sendKeys(username);	
	}
	
	public void inputPassword(String password) {
		driver.findElement(passwordInputField).sendKeys(password);
	}
	
	public void clickLoginBtn() {
		driver.findElement(loginBtn).click();
	}
}
