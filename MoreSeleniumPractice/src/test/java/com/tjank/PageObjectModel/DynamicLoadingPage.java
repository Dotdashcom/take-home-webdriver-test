package com.tjank.PageObjectModel;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DynamicLoadingPage extends WebPage {

	protected WebDriverWait await;
	protected Actions actions;
	protected Alert alert;
	protected Action action;
	
	public DynamicLoadingPage() {
		this.URL = this.URL.concat("/dynamic_loading/2");
		System.out.println(URL);
	}
	
	@Override
	public void setup() {
		String url = this.getUrl();
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		assertEquals(driver.getCurrentUrl(),url);
	}

	public String getUrl() {
		return this.URL;
	}	

	public void waitForPageToLoad() {
		await = new WebDriverWait(driver,Duration.ofSeconds(10));
		await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Dynamically Loaded Page Elements']")));
		loadPageFactory();
		actions = new Actions(driver);
	}
	
	public void loadPageFactory() {
		PageFactory.initElements(driver, this); 
	}
	
	
	public void clickStartButton() {
		WebElement el = driver.findElement(By.xpath("//button[text() = 'Start']"));
		el.click();
		await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Hello World!']")));
		WebElement ek = getHelloWorldElement();
		Assert.assertTrue(ek.isDisplayed());
	}
	
	public WebElement getHelloWorldElement() {
		return driver.findElement(By.xpath("//*[text() = 'Hello World!']"));
	}
	
}
