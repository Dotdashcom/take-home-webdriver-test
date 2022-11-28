package testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.NotificationMessage;

public class TC_NotificationMessage extends BaseClass {

	@Test	
	public void VerifyNotificationMessage() throws InterruptedException {

		driver.get("http://localhost:7080/notification_message_rendered");
		
	        NotificationMessage np = new NotificationMessage(driver);
	        
	 
	              int count = 0;
	               while (count <= 3){
	                  np.ClickLink();
	                  String NMessage = np.getNotificationMessage();
	                  System.out.println("Notification message is: " + NMessage);
	                   Assert.assertTrue("Notification message does not contains the given text",NMessage.contains("Action unsuccesful, please try again") || NMessage.contains("Action successful") );
	                   count++;
	               }

			}


	}	


