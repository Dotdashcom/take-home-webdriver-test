package pageObjects;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewTabPage extends BaseTemplate{

	public NewTabPage(WebDriver driver) {
		super(driver);
	
	}
	
	private final By newTablink = By.cssSelector("div[class='example'] a");
	
	
	   public void clickOnNewTabLink() {
		   wait.until(ExpectedConditions.elementToBeClickable(newTablink));
	        driver.findElement(newTablink).sendKeys(Keys.CONTROL, Keys.RETURN);
	    }
	
	
	   public void switchToNewTab() {
	        String oldTab = driver.getWindowHandle();
	        Set<String> newTab = driver.getWindowHandles();
	        newTab.remove(oldTab);
	        driver.switchTo().window(newTab.iterator().next());
	    }
	

}
