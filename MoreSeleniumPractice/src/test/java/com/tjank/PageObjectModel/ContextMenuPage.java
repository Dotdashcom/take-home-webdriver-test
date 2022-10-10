package com.tjank.PageObjectModel;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ContextMenuPage extends WebPage {

	protected WebDriverWait await;
	protected Actions actions;
	protected Alert alert;
	
	public ContextMenuPage() {
		this.URL = this.URL.concat("/context_menu");
		System.out.println(URL);
	}
	
	@FindBy(xpath = "//*[@id = 'hot-spot']")
	public WebElement hotspot;	

	public String getUrl() {
		return this.URL;
	}	

	public void waitForPageToLoad() {
		await = new WebDriverWait(driver,Duration.ofSeconds(5));
		await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Context Menu']")));
		loadPageFactory();
		actions = new Actions(driver);
	}
	
	public void loadPageFactory() {
		PageFactory.initElements(driver, this); 
	}
	
	public void rightClickContextMenu() {
		actions.moveToElement(hotspot);
		actions.contextClick(hotspot).perform();
	}
	
	public void waitForAlertToDisplay() {
		await.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
	}
	
	public void verifyAlertText() {
		String actual = alert.getText();
		alert.accept();
		Assert.assertEquals(actual, "You selected a context menu");
	}
}
