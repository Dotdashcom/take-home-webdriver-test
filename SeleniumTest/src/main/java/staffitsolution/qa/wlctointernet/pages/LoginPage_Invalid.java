package staffitsolution.qa.wlctointernet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage_Invalid {

	private WebDriver driver;

	private By username = By.xpath("//input[@id='username']");
	private By password = By.xpath("//input[@id='password']");
	private By loginBtn = By.xpath("//button[@type='submit']");

	public LoginPage_Invalid(WebDriver driver) {
		this.driver = driver;
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public String getLoginPageUrl() {
		return driver.getCurrentUrl();
	}

	public void dologin(String un, String pwd) {
		System.out.println("login creds are: " + un + " :" + pwd);
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
	}

}
