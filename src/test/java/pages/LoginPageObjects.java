package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {

	public WebDriver driver;

	public LoginPageObjects(WebDriver driver) {

		this.driver = driver;
	}

	private By username = By.xpath("//input[@id='username']");

	private By password = By.xpath("//input[@id='password']");

	private By login = By.xpath("//button[@type='submit']");
	
	private By flashMessage = By.xpath("//div[@id='flash-messages']//div[1]");

	
	public WebElement userName() {

		return driver.findElement(username);
	}

	public WebElement password() {

		return driver.findElement(password);
	}

	public WebElement login() {

		return driver.findElement(login);
	}
	public WebElement flashMessage() {

		return driver.findElement(flashMessage);
	}
	
	
	
	
}
