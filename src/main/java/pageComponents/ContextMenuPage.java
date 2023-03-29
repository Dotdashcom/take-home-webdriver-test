package pageComponents;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage
{
	WebDriver driver;
	Actions actions;
	Alert alert;
	public ContextMenuPage(WebDriver driver)
	{
		this.driver = driver;
		actions = new Actions(driver);
	}
	By hotSpotElement = By.id("hot-spot");
	By contextMenuElement = By.name("the-internet");
	
	public void rightClickHotSpot()
	{
		actions.contextClick(driver.findElement(hotSpotElement)).perform();;
	}
	
	public String getAlertText()
	{
		alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		return alertText;
	}
}
