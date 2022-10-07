package com.tjank.PageObjectModel;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class JavascriptErrorPage extends WebPage {

	protected WebDriverWait await;
	protected Actions actions;
	protected Alert alert;
	protected Action action;
	
	public JavascriptErrorPage() {
		this.URL = this.URL.concat("/javascript_error");
		System.out.println(URL);
	}
	
	@Override
	public void setup() {
		String url = this.getUrl();
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		Assert.assertEquals(driver.getCurrentUrl(),url);
	}

	public String getUrl() {
		return this.URL;
	}	

	public void waitForPageToLoad() {
		await = new WebDriverWait(driver,Duration.ofSeconds(10));
		await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Javascript injection')]")));
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
	
	public void validateErrorMessage() {
		LogEntries entries = driver.manage().logs().get(LogType.BROWSER);
		List<LogEntry> lg = entries.getAll();
		for(LogEntry logEntry : lg) {
			System.out.println(logEntry);
			if(logEntry.toString().contains("Cannot read properties of undefined (reading 'xyz')")) {
				Assert.assertTrue(true);
				return;
			}
		}
		Assert.fail();
	}
		
}
