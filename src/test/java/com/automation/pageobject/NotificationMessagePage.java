package com.automation.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class NotificationMessagePage {
	public static final By NOTIFICATIONMESSAGEHEADER=By.xpath("//h3[text()='Notification Message']");
	public static final By CLICKHERE=By.xpath("//a[text()='Click here']");
	public static final By MESSAGE=By.xpath("//div[@id='flash']");
	
	
	public static void validateNotificationMessageHeader(WebDriver driver) {
		WebElement element= driver.findElement(NOTIFICATIONMESSAGEHEADER);
		Assert.assertTrue(element.isDisplayed(), "Notification Message Header is not Displaying");
	}

	public static void validateClickMessage(WebDriver driver) {
		int flag=0;
		for(int i=0;i<100;i++) {
			driver.findElement(CLICKHERE).click();
			
			String message=driver.findElement(MESSAGE).getText();
			System.out.println("print message"+message.trim());
			if(message.trim().contains("Action successful")) {
				flag+=1;
			}
             if(message.trim().contains("Action unsuccesful, please try again")) {
            	 flag+=1;
			}
             if(message.trim().contains("Action Unsuccessful")) {
            	 flag+=1;
 			}
             System.out.println("print flag"+flag);
             if(flag==3) {
            	 break;
             }
			
		}
	
		Assert.assertTrue(flag==3);
		
	}
	
}
