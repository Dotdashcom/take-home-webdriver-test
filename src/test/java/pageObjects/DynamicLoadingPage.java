package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicLoadingPage extends BaseTemplate{

	public DynamicLoadingPage(WebDriver driver) {
		super(driver);
	}
	
	private final By startButton = By.xpath("//button[text()='Start']");
	private final By helloText = By.cssSelector("div[id='finish'] h4");
	
	public void clickStartButton() {
		wait.until(ExpectedConditions.elementToBeClickable(startButton));
		driver.findElement(startButton).click();
	}
	
	public String fetchHelloTextIfDisplayed() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(helloText));
		return driver.findElement(helloText).getText();
	}

}
