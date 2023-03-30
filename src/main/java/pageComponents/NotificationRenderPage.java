package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NotificationRenderPage
{
	WebDriver driver;
	public  NotificationRenderPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By clickHereLinkButtonElement = By.xpath("//a[contains(text(),'Click here')]");
	By flashMessageElement = By.id("flash");
	
	public void clickTheLink()
	{
		driver.findElement(clickHereLinkButtonElement);
	}
	
	public String getTheFlashMessage()
	{
		return driver.findElement(flashMessageElement).getText();
	}
	
}
