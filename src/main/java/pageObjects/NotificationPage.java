package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NotificationPage {
	public WebDriver driver;
	By clickLinkLocator = By.xpath("//*[@id=\'content\']/div/p/a");
	By notificationText = By.xpath("//*[@id=\'flash\']");
	
	public NotificationPage(WebDriver driver)
	
	{
		this.driver=driver;
	}
	
	public WebElement getClickLinkLocator()
	{
		return driver.findElement(clickLinkLocator);
	}
	
	public WebElement getNotificationPage()
	{
		return driver.findElement(notificationText);
	}
	

}
