package staffitsolution.qa.wlctointernet.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import staffitsolution.qa.wlctointernet.Base.BaseTest;

public class JavaScriptAlertsTest extends BaseTest{
	@Test
	public void javaScriptAlertsTest() throws InterruptedException 
	{
		driver.get(prop.getProperty("javascriptalerturl"));
		Thread.sleep(2000);
		System.out.println("------JS Alert Verification-----");
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Alert al= driver.switchTo().alert();
		String JSAlertmsg= al.getText();
		System.out.println("JS Alert message: " +JSAlertmsg);
		al.accept();
		String Successmsg=driver.findElement(By.xpath("//p[@id='result']")).getText();
		Assert.assertEquals(Successmsg, "You successfuly clicked an alert");

		System.out.println("------JS Confirm Verification-----");
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		Alert al1= driver.switchTo().alert();
		String JSconfrmmsg= al1.getText();
		System.out.println("JS confirm message: " +JSconfrmmsg);
		al.accept();
		String result=driver.findElement(By.xpath("//p[@id='result']")).getText();
		Assert.assertEquals(result, "You clicked: Ok");
		
		System.out.println("------JS Prompt Verification-----");
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Alert al2= driver.switchTo().alert();
		String JSPromptmsg= al2.getText();
		System.out.println("JS Prompt message: " +JSPromptmsg);
		al2.sendKeys("Selenium");
//		String Results=(al2.getText());
		al2.accept();
		String result1=driver.findElement(By.xpath("//p[@id='result']")).getText();
		System.out.println("Alert Prompt type message is: " +result1);
		Assert.assertEquals(result1, "You entered: Selenium");
		
}
}