package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class NotificationMessagePage extends BaseDriver{
	public NotificationMessagePage(WebDriver driver){
        super(driver);
    }
	
	@FindBy(xpath="//a[@href='/notification_message']")
	public WebElement clickHereLnk;
	
	public String getNotificationMessage() throws InterruptedException {
		clickHereLnk.click();
		Thread.sleep(1000);
		String text = driver.findElement(By.cssSelector("div#flash-messages div#flash")).getText();
		return text;
	}
}
