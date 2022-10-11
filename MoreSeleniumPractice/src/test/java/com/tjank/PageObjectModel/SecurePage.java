package com.tjank.PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecurePage extends WebPage {

	protected WebDriverWait await;
	
	@FindBy(xpath = "//*[contains(text(),'Welcome to the Secure Area.')]")
	public WebElement secureText;
	
	@FindBy(xpath="//a[@href='/logout']")
	public WebElement logoutButton;
	
	public void waitForSuccesfulLogin() {
		await = new WebDriverWait(driver,Duration.ofSeconds(5));
		await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'You logged into a secure area!')]")));
	}
	
	public String getSecureText() {
		PageFactory.initElements(driver, this);
		return this.secureText.getText();
	}
	
	public void clickLogoutButton() {
		logoutButton.click();
	}
}
