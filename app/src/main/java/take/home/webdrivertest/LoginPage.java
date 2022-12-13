package take.home.webdrivertest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	By Username = By.id("username");
	By Password = By.id("password");
	By LoginButton = By.cssSelector(".fa");

	public void clickElement(By element) {
		driver.findElement(element).click();
	}

	public void sendKeys(By id, String userName) {
		driver.findElement(id).sendKeys(userName);
	}
}