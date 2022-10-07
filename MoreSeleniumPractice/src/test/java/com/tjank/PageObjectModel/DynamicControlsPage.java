package com.tjank.PageObjectModel;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

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

public class DynamicControlsPage extends WebPage {

	protected WebDriverWait await;
	protected Actions actions;
	protected Alert alert;
	protected Action action;
	
	public DynamicControlsPage() {
		this.URL = this.URL.concat("/dynamic_controls");
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
		await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Dynamic Controls']")));
		loadPageFactory();
		actions = new Actions(driver);
	}
	
	public void loadPageFactory() {
		PageFactory.initElements(driver, this); 
	}
	
	public WebElement getTextBox() {
		WebElement el = driver.findElement(By.xpath("//input[@type='text']"));
		return el;
	}
	
	
	public void clickRemoveButton() {
		WebElement el = driver.findElement(By.xpath("//button[text() = 'Remove']"));
		el.click();
		await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'gone')]")));
		List<WebElement> els = driver.findElements(By.xpath("//input[@type='checkbox']"));
		Assert.assertTrue(els.size() == 0);
	}
	
	public void clickAddButton() {
		WebElement el = driver.findElement(By.xpath("//button[text() = 'Add']"));
		el.click();
		await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox']")));
		List<WebElement> els = driver.findElements(By.xpath("//input[@type='checkbox']"));
		Assert.assertTrue(els.size() == 1);
	}
	
	public void clickEnableButton() {
		WebElement el = driver.findElement(By.xpath("//button[text() = 'Enable']"));
		el.click();
		await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'enabled')]")));
		WebElement textBox = getTextBox();
		Assert.assertTrue(textBox.isEnabled());
	}
	
	public void clickDisableButton() {
		WebElement el = driver.findElement(By.xpath("//button[text() = 'Disable']"));
		el.click();
		await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'disabled')]")));
		WebElement textBox = getTextBox();
		Assert.assertTrue(!textBox.isEnabled());
	}
	
}
