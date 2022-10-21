package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class NotificationMessagePO {

	WebDriver driver;
	public NotificationMessagePO(WebDriver driver) {
		this.driver= driver;
	}
		
	public void NotificationMessage()   {
		
		WebElement Click1= driver.findElement(By.xpath("//a[text()='Click here']"));
		Click1.click();
		
		WebElement Notification1= driver.findElement(By.id("flash"));
		Notification1.getText();
		
		WebElement Click2= driver.findElement(By.xpath("//a[text()='Click here']"));
		Click2.click();
		
		WebElement Notification2= driver.findElement(By.id("flash"));
		Notification2.getText();
		
		Assert.assertNotEquals(false, Notification1);
	
	}
	
	}
	


