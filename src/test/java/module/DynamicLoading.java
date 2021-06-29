package module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configuration.PageLoader;

public class DynamicLoading {
	
	private WebDriver driver = null;
	private final int MAX = 60; // max time in seconds to wait for element
	
	@FindBy(how=How.TAG_NAME, using="button")	
	private WebElement startButton;
	
	public DynamicLoading(WebDriver driver) {
		this.driver = driver;
		this.loadPage();		
		PageFactory.initElements(driver, this);
	}
	
	public void clickStartButton() {
		startButton.click();
	}

	public String getCompletionMessage() {
		WebDriverWait wait = new WebDriverWait(driver, MAX);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
		return driver.findElement(By.id("finish")).getText();
	}
	
	public void loadPage() {
		PageLoader.loadPage(driver, "/dynamic_loading/2");		
	}
	
	
}
