package take.home.webdrivertest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;
	WebElement username;
	WebElement password;
	WebElement loginButton;
	WebElement loginResult;

	public LoginPage(WebDriver driver) {
		this.driver = driver;

		username = driver.findElement(By.id("username"));
		password = driver.findElement(By.id("password"));
		loginButton = driver.findElement(By.cssSelector(".fa"));
	}

	public void clickElement(WebElement element) {
		element.click();
	}

	public void sendKeys(WebElement element, String userName) {
		element.sendKeys(userName);
	}

	public String getLoginResult() {
		 loginResult = driver.findElement(By.cssSelector(".flash"));
		return loginResult.getText();
	}

}