package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	By usernameElement = By.id("username");
	By passwordElement = By.id("password");
	By loginButtonElement = By.xpath("//button[@type=\"submit\"]");
	By pageHeaderElement = By.xpath("//h2[text()='Login Page']");
	
	public void setUsername(String username)
	{
		driver.findElement(usernameElement).sendKeys(username);
	}
	public void setPassword(String password)
	{
		driver.findElement(passwordElement).sendKeys(password);
	}
	public void clickLoginButton()
	{
		driver.findElement(loginButtonElement).click();
	}
	public String getHeader()
	{
		return driver.findElement(pageHeaderElement).getText();
	}
}
