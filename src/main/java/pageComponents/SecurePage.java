package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecurePage
{
	WebDriver driver;
	public SecurePage(WebDriver driver)
	{
		this.driver = driver;
	}
	By secureHeaderElement = By.xpath("//h2[text()=' Secure Area']");
	By logoutButtonElement = By.xpath("//i[text()=' Logout']");
	
	public void clickLogoutButton()
	{
		driver.findElement(logoutButtonElement).click();
	}
	public String getSecureHeader()
	{
		return driver.findElement(secureHeaderElement).getText();
	}
}
