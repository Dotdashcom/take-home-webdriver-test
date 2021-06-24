package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testBase.TestBase;

public class JavaScriptError extends TestBase {
	@BeforeTest
	public void beforeJavaScriptErrorTest() {
		setup();
		driver.get("http://localhost:7080/javascript_error");
	}

	@AfterTest
	public void afterJavaScrpitErrorTest() {
		teardown();
	}
	
	@Test
	public void javaScriptErrorTest() {
		//driver.findElement(By.xpath("//a[contains(text(),'JavaScript onload event error')]")).click();
		String jsErrorMsg = driver.findElement(By.xpath("//body//p")).getText();
		Assert.assertEquals(jsErrorMsg, "This page has a JavaScript error in the onload event. This is often a problem to using normal Javascript injection techniques.");
	}

}
