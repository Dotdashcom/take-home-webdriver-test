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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MouseHoverPage extends WebPage {

	protected WebDriverWait await;
	protected Actions actions;
	protected Alert alert;
	protected Action action;
	
	public MouseHoverPage() {
		this.URL = this.URL.concat("/hovers");
		System.out.println(URL);
	}
	
	@FindBy(xpath = "//*[@alt='User Avatar']")
	public List<WebElement> images;
	
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
		await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Hovers']")));
		loadPageFactory();
		actions = new Actions(driver);
	}
	
	public void loadPageFactory() {
		PageFactory.initElements(driver, this); 
	}
	
	public List<WebElement> getImages(){
		return images;
	}
	
	public void waitForSeconds(int secs) {
		try {
			Thread.sleep(secs * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public WebElement getImageText() {
		return driver.findElement(By.xpath("//*[@alt='User Avatar']"));
	}
	
	public void verifyImageText(List<WebElement> images) {
		for(int i = 0; i < images.size(); i++) {
			actions.moveToElement(images.get(i)).perform();
			waitForSeconds(1);
			Assert.assertTrue(getImageText().isDisplayed());
		}
	}
}
