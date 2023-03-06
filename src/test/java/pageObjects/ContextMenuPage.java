package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ContextMenuPage extends BaseTemplate{

	public ContextMenuPage(WebDriver driver) {
		super(driver);
	}
	
	private final By contextMenuBox = By.id("hot-spot");
	
	public void performRightClickOnHotspot() {
		wait.until(ExpectedConditions.elementToBeClickable(contextMenuBox));
		new Actions(driver).contextClick(driver.findElement(contextMenuBox)).perform();
	}
	
	public String getJSAlertMessage() {
		Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        alert.accept();
        return alertMessage;
	}
	
}
