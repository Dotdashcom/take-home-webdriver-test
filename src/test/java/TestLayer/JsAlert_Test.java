package TestLayer;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PomPackage.JsAlert;

public class JsAlert_Test extends BaseClass {
	JsAlert ja;
	public  JsAlert_Test() {
		super();
	}
	@BeforeMethod
	public void initsetup() {
		initiation();
		ja=new  JsAlert();
		
	}
	@Test
	public void tcJSAlert() throws InterruptedException {
		ja.jsArt.click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "I am a JS Alert");
		alert.accept();
		Assert.assertEquals(ja.msg.getText(), "You successfuly clicked an alert");
		Thread.sleep(2000);

		ja.jsCon.click();
		alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "I am a JS Confirm");
		alert.accept();
		Assert.assertEquals(ja.msg.getText(), "You clicked: Ok");
		Thread.sleep(2000);

		ja.jsPro.click();
		alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "I am a JS prompt");
		alert.sendKeys("This is JS prompt text");
		alert.accept();
		Assert.assertEquals(ja.msg.getText(), "You entered: This is JS prompt text");
		Thread.sleep(2000);
	}

	@AfterMethod
	public void close() {
	driver.close();
	}

}
