package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FloatingMenuPage extends BaseTemplate {
	
	private final By menu = By.cssSelector("#menu ul li");
	

	public FloatingMenuPage(WebDriver driver) {
		super(driver);
	}
	
	public void scrollPageToBottom()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public boolean isMenuDisplayed() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(menu));
		if(driver.findElement(menu).isDisplayed())
			return true;
		else
			return false;
	}

	
}
