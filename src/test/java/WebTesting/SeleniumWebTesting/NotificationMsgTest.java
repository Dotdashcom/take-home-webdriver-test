package WebTesting.SeleniumWebTesting;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class NotificationMsgTest  extends base {

	@Test()
	public void NotificationMsgTest() throws IOException, InterruptedException
	{
		//Driver navigating to the URL
		driver.get("http://localhost:7080/notification_message_rendered");
		
		WebElement clickHere, flashMeassage;
		for(int i=0; i<4 ; i++)
		{
			clickHere = driver.findElement(By.xpath("//a[contains(text(),'Click here')]"));
			//Clicking on webelement to check the flash message
			clickHere.click();
			flashMeassage = driver.findElement(By.id("flash"));
			Boolean check = false;
			//checking if the flash message contains one of the multiple messages
			if (flashMeassage.getText().contains("Action successful\n" + 
					"×") || flashMeassage.getText().contains("Action unsuccesful, please try again\n" + 
							"×") || flashMeassage.getText().contains("Action Unsuccessful\n"
			+ "×"))
			{
				//changing to true as message is found in the flash message
				check = true;
			}
			Assert.assertTrue(check);
		}
		
	}

}