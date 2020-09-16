package TestSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.BrowserFactory;

public class Notification_Message {

	WebDriver driver;

	@BeforeMethod
	public void launchbrowser() {
		// launch browser
		driver = BrowserFactory.startBrowser();
		driver.get("http://localhost:7080/notification_message_rendered");
		driver.manage().window().maximize();

	}
	@Test
	public void validate_message() {
		
		driver.findElement(By.partialLinkText("Click here")).click();
		
		WebElement message_notification = driver.findElement(By.xpath("//*[@id='flash-messages']"));
		message_notification.isDisplayed();
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.close();
		// driver.quit();
	}
}
