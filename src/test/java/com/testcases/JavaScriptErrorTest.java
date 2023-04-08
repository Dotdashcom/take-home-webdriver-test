package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import com.base.Base;
import com.pages.JavaScriptErrorPage;

public class JavaScriptErrorTest extends Base {
	
	JavaScriptErrorPage jsp;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		driver.findElement(By.linkText("JavaScript onload event error")).click();
	}
	
	@Test
	public void JavascriptErrorTest() {
		jsp=new JavaScriptErrorPage();
		JavaScriptErrorPage.captureJavaScript(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
