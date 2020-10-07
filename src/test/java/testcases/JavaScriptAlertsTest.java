package testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestBase;

public class JavaScriptAlertsTest extends TestBase{
	
	public JavaScriptAlertsTest() throws IOException {
		super();	
	}
	
	@Test  
	public void verifyJavaScriptAlert() throws InterruptedException
	{
		driver.get(urlvalues.url_javascript);
		data.jsbutton.click();
		
		//handle the JavaScript ALert
		String s1 = driver.switchTo().alert().getText();
		Thread.sleep(2000);
		String s2 = "I am a JS Alert";
		Assert.assertEquals(s1,s2);
		
		//click on cancel using dismiss() method in JavaScript Alert
		driver.switchTo().alert().dismiss();
		
		data.jsconfirm.click();
		String v1 = driver.switchTo().alert().getText();
		String v2 = "I am a JS Confirm";
		Assert.assertEquals(v1,v2);
		Thread.sleep(2000);
		
		//accept the alert using accept() method
		driver.switchTo().alert().accept();	
		
		data.jsprompt.click();
		
		//passing the text in alert using SendKeys() method
		driver.switchTo().alert().sendKeys(" hello abcd ");
		driver.switchTo().alert().accept();
		Assert.assertTrue(data.alertmsg.isDisplayed());
		System.out.println(data.alertmsg.getText());	
		System.out.println("Alert test is passed...");	
	}
}
