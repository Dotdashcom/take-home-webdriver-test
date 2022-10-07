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

public class CheckboxPage extends WebPage {

	protected WebDriverWait await;
	
	public CheckboxPage() {
		this.URL = this.URL.concat("/checkboxes");
		System.out.println(URL);
	}
	
	@FindBy(xpath = "//input[@type = 'checkbox'][1]")
	public WebElement checkBoxOne;	
	
	@FindBy(xpath = "//input[@type = 'checkbox'][2]")
	public WebElement checkBoxTwo;
	
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
		await = new WebDriverWait(driver,Duration.ofSeconds(5));
		await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Checkboxes']")));
		loadPageFactory();
	}
	
	public void loadPageFactory() {
		PageFactory.initElements(driver, this); 
	}
	
	public void clickFirstCheckbox() {
		checkBoxOne.click();
	}
	
	public void clickSecondCheckbox() {
		checkBoxTwo.click();
	}
}
