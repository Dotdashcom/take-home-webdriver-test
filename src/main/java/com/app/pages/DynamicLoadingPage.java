package com.app.pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.util.PageLinks;

public class DynamicLoadingPage extends BasePage{

	public DynamicLoadingPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//button[text()='Start']")
	private WebElement btnStart;
	
	@FindBy(id = "loading")
	private WebElement loadingSpinner;
	

	public void visitDynamicLoadingPage() {
		getDriver().get(PageLinks.DYNAMIC_LOADING_PAGE);
	}
	
	public void verifyDynamicLoading() {
		WebDriver driver = getDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		btnStart.click();
		
		wait.until(ExpectedConditions.invisibilityOf(loadingSpinner));
		
		String helloWorld = driver.findElement(By.xpath("//div[@id='finish']/h4")).getText().trim();
		
		assertEquals("Hello World!", helloWorld);
		
	}
}
