package com.tjank.PageObjectModel;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class JavascriptAlertsPage extends WebPage {

	protected WebDriverWait await;
	protected Actions actions;
	protected Alert alert;
	protected Action action;
	
	public JavascriptAlertsPage() {
		this.URL = this.URL.concat("/javascript_alerts");
		System.out.println(URL);
	}
	
	@FindBy(xpath = "//button[text()='Click for JS Alert']")
	public WebElement jsAlert;
	
	@FindBy(xpath = "//button[text()='Click for JS Confirm']")
	public WebElement jsConfirm;
	
	@FindBy(xpath = "//button[text()='Click for JS Prompt']")
	public WebElement jsPrompt;

	public String getUrl() {
		return this.URL;
	}	

	public void waitForPageToLoad() {
		await = new WebDriverWait(driver,Duration.ofSeconds(10));
		await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='JavaScript Alerts']")));
		loadPageFactory();
		actions = new Actions(driver);
	}
	
	public void loadPageFactory() {
		PageFactory.initElements(driver, this); 
	}
	
	public void waitForSeconds(int secs) {
		try {
			Thread.sleep(secs * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void verifyAlertMessage() {
		jsAlert.click();
		alert = await.until(ExpectedConditions.alertIsPresent());
		String text = alert.getText();
		alert.accept();
		Assert.assertEquals(text, "I am a JS Alert");
	}
	
	public void verifyAlertConfirm() {
		jsConfirm.click();
		alert = await.until(ExpectedConditions.alertIsPresent());
		String text = alert.getText();
		alert.accept();
		Assert.assertEquals(text, "I am a JS Confirm");
	}
	
	public void verifyAlertPrompt() {
		jsPrompt.click();
		alert = await.until(ExpectedConditions.alertIsPresent());
		String prompt = "test";
		alert.sendKeys(prompt);
		alert.accept();
		WebElement result = await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='result']")));
		Assert.assertEquals(result.getText(), "You entered: " + prompt);
	}
		
}
