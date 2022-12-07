package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


	private String page = "login";

	private By usernameInput = By.id("username");
	private By passwordInput = By.id("password"); 
	private By loginButton = By.cssSelector("#login > button");

	private By flashMessage = By.id("flash-messages");

	public LoginPage(WebDriver driver) {
		super(driver);
		setPageUrl(page);
	}


	public void goToPage() {
		driver.get(getUrl());
	}


	public String getFlashMessage() {
		return driver.findElement(flashMessage).getText().toString();
	}


	private void insertUsername(String username) {
		driver.findElement(usernameInput).sendKeys(username);
	}

	private void insertPassword(String password) {
		driver.findElement(passwordInput).sendKeys(password);
	}

	private void clickLogin() {
		driver.findElement(loginButton).click();
	}

	public void login(String username, String password) {
		insertUsername(username);
		insertPassword(password);
		clickLogin();
	}

	public void openPage(String url) {
		driver.get(url);
	}
}
