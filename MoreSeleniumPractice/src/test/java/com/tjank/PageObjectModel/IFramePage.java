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

public class IFramePage extends WebPage {

	protected WebDriverWait await;
	protected Actions actions;
	protected Alert alert;
	protected Action action;
	
	public IFramePage() {
		this.URL = this.URL.concat("/iframe");
		System.out.println(URL);
	}
	
	@FindBy(xpath = "//*[@class='tox-icon']")
	public WebElement xIcon;
	
	@FindBy(xpath = "//*[@id='mce_0_ifr']")
	public WebElement iFrame;
	
	@FindBy(xpath = "//*[@id='tinymce']")
	public WebElement textInput;

	public String getUrl() {
		return this.URL;
	}	

	public void waitForPageToLoad() {
		await = new WebDriverWait(driver,Duration.ofSeconds(10));
		await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']")));
		loadPageFactory();
		actions = new Actions(driver);
	}
	
	public void loadPageFactory() {
		PageFactory.initElements(driver, this); 
	}
	
	public void clickXSymbol() {
		xIcon.click();
		driver.switchTo().frame(iFrame);
	}
	
	public void typeText() {
		textInput.clear();
		textInput.sendKeys("It works!");
		Assert.assertEquals(textInput.getText(), "It works!");
	}
}
