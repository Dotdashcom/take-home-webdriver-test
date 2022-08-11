package Test;

import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Util.MainClass;

public class NotificationMsgTest extends MainClass{

	@Before
    public void Setup()
	{
		startBrowser();
		driver.get("http://localhost:7080/notification_message_rendered");
	}
    @Test 
    public void Verify_AdditionalInfoDisplyedWhenHoverOver() throws Exception
    {
    	String msg1 = "Action successful";
    	String msg2 = "Action unsuccesful, please try again";
    	String msg3 = "Action unsuccessful";
        //act
    	WebElement firstclickHere = driver.findElement(By.xpath("//*[@id='content']/div/p/a"));
    	firstclickHere.click();
    	
   		//Verify
    	
   		assertTrue(driver.findElement(By.xpath("//*[@id='flash']")).isDisplayed());
   		String Notificationmsg1 = driver.findElement(By.xpath("//*[@id='flash']")).getText();
   		assertTrue(Notificationmsg1.contains(msg1) || Notificationmsg1.contains(msg2) || Notificationmsg1.contains(msg3));
    			
        //SecondClick
   		WebElement SecondclickHere = driver.findElement(By.xpath("//*[@id='content']/div/p/a"));
   		SecondclickHere.click();
   		
   		//Verify
   		assertTrue(driver.findElement(By.xpath("//*[@id='flash']")).isDisplayed());
  		String Notificationmsg2 = driver.findElement(By.xpath("//*[@id='flash']")).getText();
   		assertTrue(Notificationmsg2.contains(msg1) || Notificationmsg2.contains(msg2) || Notificationmsg2.contains(msg3));
    			
    	//ThirdClick
   		WebElement ThirdclickHere = driver.findElement(By.xpath("//*[@id='content']/div/p/a"));
   		ThirdclickHere.click();
   		
   		//Verify
    	assertTrue(driver.findElement(By.xpath("//*[@id='flash']")).isDisplayed());
    	String Notificationmsg3 = driver.findElement(By.xpath("//*[@id='flash']")).getText();
    	assertTrue(Notificationmsg3.contains(msg1) || Notificationmsg3.contains(msg2) || Notificationmsg3.contains(msg3));
    }
    
    @After 
    public void tearDown() 
    {
    	closeBrowser();
    }


}
