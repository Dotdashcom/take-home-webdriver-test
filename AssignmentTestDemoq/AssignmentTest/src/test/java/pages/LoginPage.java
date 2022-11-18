package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {		
		this.driver = driver;
	}
	
	By usernameTextBox = By.cssSelector("#username");
	By passwordTextBox = By.cssSelector("#password");
	By loginButton = By.cssSelector("button[type='submit']");
	By inValidUsernameMessage = By.cssSelector("#flash-messages div");
	
	public void EnterUsername(String name) {
		driver.findElement(usernameTextBox).sendKeys(name);
	}
	
	public void EnterPassword(String password) {
		driver.findElement(passwordTextBox).sendKeys(password);
	}
	
	public void ClickLoginButton() {
		driver.findElement(loginButton).click();
	}
	
	public void VerifyHeadingInavlidLogin(String actual) {		 
		String text = driver.findElement(inValidUsernameMessage).getText().trim();
		int lastIndex = text.indexOf("!");
		String expected = text.substring(0, lastIndex +  1);
		
		Assert.assertEquals(actual, expected);
	}
	
}
