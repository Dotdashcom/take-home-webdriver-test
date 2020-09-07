package dockers;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotificationMessage {
	   
		@Test
	    public void Notification() throws InterruptedException{			
			String url = "http://localhost:7080/notification_message_rendered";
			LoginWebDriver loginWebDriver = new LoginWebDriver();
			WebDriver driver = loginWebDriver.Login(url);
			
			driver.manage().window().maximize();
			
			WebElement clickElement = driver.findElement(By.xpath("//a[contains(text(),'Click here')]"));
			clickElement.click();
			Thread.sleep(2000);
			WebElement messageElement = driver.findElement(By.xpath("//a[@class='close']"));
			messageElement.click();
			driver.close();

			}
}