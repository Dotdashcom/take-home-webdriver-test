package webtests.Testlayers;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import webtests.BasePackage.WT_BaseClass;
import webtests.Pageobjects.WT_014_JavaScriptAlerts_POM;

public class WT_14_JavaScriptAlerts_Test extends WT_BaseClass {
	
	 WT_014_JavaScriptAlerts_POM jsa;
	 
	 //Constructor
	public WT_14_JavaScriptAlerts_Test() {
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
		
		jsa = new  WT_014_JavaScriptAlerts_POM();
		
		driver.get(pr.getProperty("baseurl")+"/javascript_alerts");
		logg.info("****JavaScriptAlerts url opened****");
	}
	
	
	@Test(priority = 1)
	public void JavaScriptAlertTest() throws InterruptedException {
		jsa.JSAlertbutton();
		
		Alert alert= driver.switchTo().alert();
		   
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		logg.info("****Test switched to Alert****");
		
		String alertmsg = alert.getText(); 
		System.out.println(alertmsg);
		  
		 Assert.assertEquals(alertmsg, "I am a JS Alert");
		 logg.info("****Test Passed****");
	}
	
	 @Test(priority = 2)
   	public void JavaScriptConfirmTest() throws InterruptedException {
		
	   jsa.JSConfirmbutton();
	   Alert alert= driver.switchTo().alert();
	   
	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		logg.info("****Test switched to Alert****");
		
	   String almsg = alert.getText();
	   alert.accept();
	   System.out.println(almsg);
		 
		 Assert.assertEquals(almsg, "I am a JS Confirm");
		 jsa.SuccessfulMessage();
		 logg.info("****Test Passed****");
	}
	 @Test(priority = 3)
	public void JavaScriptPromptTest() throws InterruptedException, IOException {
		 jsa.JSPromptbutton();
		 
		 Alert alert= driver.switchTo().alert();
		 
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.alertIsPresent());
			logg.info("****Test switched to Alert****");
			
		 alert.sendKeys("Hello World");
		 alert.accept();
		 
		 Thread.sleep(3000);
		String text= jsa.SuccessfulMessage();
		 if (text.equals("You entered: Hello World")) {
			 Assert.assertTrue(true);
			 logg.info("****Test Passed****");
			}
		else {
			Assert.assertTrue(false);
			captureScreen(driver,"JSprompt");
			logg.info("****Test Failed****");
		 }
		 
	 }
	
	
	
}
