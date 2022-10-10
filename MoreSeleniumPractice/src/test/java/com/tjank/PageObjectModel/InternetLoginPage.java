package com.tjank.PageObjectModel;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InternetLoginPage extends WebPage{

	protected WebDriverWait await;
	
	public InternetLoginPage() {
		this.URL = this.URL.concat("/login");
		System.out.println(URL);
	}
	
	@FindBy(xpath = "//*[@id = 'username']")
	public WebElement usernameField;	
	
	@FindBy(xpath = "//*[@id = 'password']")
	public WebElement passwordField;
	
	@FindBy(xpath = "//button[@type = 'submit']")
	public WebElement loginButton;
	
	@FindBy(xpath = "//*[contains(text(),'Your username is invalid!')]")
	public WebElement loginFailedMessage;

	public String getUrl() {
		return this.URL;
	}
	
	public void waitForPageToLoad() {
		await = new WebDriverWait(driver,Duration.ofSeconds(5));
		await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Login Page')]")));
	}
	
	public void login(String username, String password) {
		PageFactory.initElements(driver, this); 
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
	}
	
	public void waitForLoginToFail() {
		await = new WebDriverWait(driver,Duration.ofSeconds(5));
		await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Your username is invalid!')]")));
	}
	
	public String getLoginFailedMessage() {
		return this.loginFailedMessage.getText().trim();
	}
}
