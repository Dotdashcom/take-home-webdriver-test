package staffitsolution.qa.wlctointernet.test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import staffitsolution.qa.wlctointernet.Base.BaseTest;

public class NotificationMsgTest extends BaseTest{
	@Test
	public void notificationMsgTest() throws InterruptedException 
	{
		String successMsg = "Action successful";
		String unsuccessMsg = "Action unsuccesful, please try again";
		driver.get(prop.getProperty("notificationmsgurl"));
		Thread.sleep(2000);
		By successful= By.xpath("//div[@id='flash']");
		
		List<String> listNotification = new ArrayList<String>();
			
		for(int i = 0;i < 6; i++) {			
			driver.findElement(By.xpath("//a[text()='Click here']")).click();
			Thread.sleep(2000);
			
			String Notificationmsg = driver.findElement(successful).getText();
			if(listNotification.size() == 0 || listNotification.indexOf(Notificationmsg) < 0) {
				listNotification.add(Notificationmsg);	
			}
		}	
		
		boolean test = listNotification.contains(successMsg);
		
		for(int i=0;i <listNotification.size();i++) {
			System.out.println(i+"]"+ listNotification.get(i));
			if(listNotification.get(i).contains(unsuccessMsg)) {
				Assert.assertTrue(listNotification.get(i).contains(unsuccessMsg));		
			}
			if(listNotification.get(i).contains(successMsg)) {
				Assert.assertTrue(listNotification.get(i).contains(successMsg));		
			}
		}
		
	}
}
