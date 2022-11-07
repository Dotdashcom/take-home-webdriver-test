package tests;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import PageObjects.JavascriptAlertsPage;
import PageObjects.OpenInNewWindowPage;
import Utility.InternetWebBaseTest;
import junit.framework.Assert;

public class JavascriptAlertsTest extends InternetWebBaseTest{
	@Test
	public void testClickForJSAlert() throws IOException {
			driver.get(loadProperties().getProperty("BASE_URL")+"javascript_alerts");
			JavascriptAlertsPage jsalert=new JavascriptAlertsPage(driver);
			jsalert.selectclickjsalert();
			Assert.assertEquals("ClickForJSAlert button is not working",driver.switchTo().alert().getText(),"I am a JS Alert");
			driver.switchTo().alert().accept();
			Assert.assertEquals("JS Alert Accept is not working",driver.getTitle(),"The Internet");
	}
	
	@Test
	public void testClickForJSConfirm() throws IOException {
		driver.get(loadProperties().getProperty("BASE_URL")+"javascript_alerts");
		JavascriptAlertsPage jsconfirm=new JavascriptAlertsPage(driver);
		jsconfirm.selectclickjsconfirm();
		Assert.assertEquals("ClickForJSConfirm button is not working",driver.switchTo().alert().getText(),"I am a JS Confirm");
		driver.switchTo().alert().accept();
		Assert.assertEquals("JS Confirm Accept is not working",driver.getTitle(),"The Internet");
		jsconfirm.selectclickjsconfirm();
		driver.switchTo().alert().dismiss();
		Assert.assertEquals("JS Confirm dismiss is not working",driver.getTitle(),"The Internet");
  }
	
	@Test
	public void testClickForJSPrompt() throws IOException, InterruptedException {
			driver.get(loadProperties().getProperty("BASE_URL")+"javascript_alerts");
			JavascriptAlertsPage jsprompt=new JavascriptAlertsPage(driver);
			Thread.sleep(2000);
			jsprompt.selectclickjsprompt();
			driver.switchTo().alert().sendKeys("Verifying prompt functionaly");
			driver.switchTo().alert().accept();
			String resultText=driver.findElement(By.id("result")).getText();
			Assert.assertTrue("Text is not entered correctly",resultText.contains("Verifying prompt functionaly"));
			jsprompt.selectclickjsprompt();
			Assert.assertEquals("ClickForJSPrompt button is not working",driver.switchTo().alert().getText(),"I am a JS prompt");
			driver.switchTo().alert().accept();
			Assert.assertEquals("JS Prompt Accept is not working",driver.getTitle(),"The Internet");
			
			
	}
	

}
