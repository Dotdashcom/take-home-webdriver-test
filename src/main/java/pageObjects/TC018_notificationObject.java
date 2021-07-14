package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC018_notificationObject{
	public WebDriver driver;
	By notificationLink = By.xpath("//a[text()='Notification Messages']");
	By notificationLink2 = By.xpath("//div[@class='example']/p/a");
	By notificationText = By.xpath("//div[@id='flash']");
	//constructor for giving a life to the driver
	public TC018_notificationObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getNotificationLink() {
		return driver.findElement(notificationLink);
	}
	
	public WebElement getNotificationLink2() {
		return driver.findElement(notificationLink2);
	}
	
	public WebElement getNotificationText() {
		return driver.findElement(notificationText);
	}
}
