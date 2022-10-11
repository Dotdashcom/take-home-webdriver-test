package com.tjank.PageObjectModel;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FloatingMenuPage extends WebPage {

	protected WebDriverWait await;
	protected Actions actions;
	protected Alert alert;
	protected Action action;
	
	public FloatingMenuPage() {
		this.URL = this.URL.concat("/floating_menu");
		System.out.println(URL);
	}
	
	@FindBy(xpath = "//*[@id='menu']")
	public WebElement floatingMenu;

	public String getUrl() {
		return this.URL;
	}	

	public void waitForPageToLoad() {
		await = new WebDriverWait(driver,Duration.ofSeconds(10));
		await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Floating Menu']")));
		loadPageFactory();
		actions = new Actions(driver);
	}
	
	public void loadPageFactory() {
		PageFactory.initElements(driver, this); 
	}
	
	public void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,450)");
	}
	
	public void verifyFloatMenu() {
		Assert.assertTrue(floatingMenu.isDisplayed());
	}
}
