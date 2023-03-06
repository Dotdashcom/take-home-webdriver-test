package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IframePage extends BaseTemplate {

	public IframePage(WebDriver driver) {
		super(driver);
	}
	
	private static final By iframe = By.cssSelector("iframe[id='mce_0_ifr']");
	private final By Input = By.cssSelector("#tinymce");

	 
	 public void activateIframe() {
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(iframe));
		 driver.switchTo().frame(driver.findElement(iframe));
	 }
	
	public void clearExistingText() {
		driver.findElement(Input).clear();
	}
	
	public void setText(String message) {
		driver.findElement(Input).sendKeys(message);
	}
	
	public String getText() {
		return driver.findElement(Input).getText();
	}
	
	

	
}
