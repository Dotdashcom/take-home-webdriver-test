package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.base.Base;
import com.pages.IframePage;


public class IframeTest extends Base{
	IframePage ip;
	@BeforeMethod
	public void setUp() {
		initialization();
		driver.findElement(By.linkText("Frames")).click();
		driver.findElement(By.linkText("iFrame")).click();
		ip=new IframePage();
	}
	
	@Test
	public void validateTheTypedtextInIframeIsAsExpected() {
		ip.switchToIframe();
		ip.enterTheText();
		Assert.assertEquals(ip.getTheEnteredtext(),"Type the text inside the IFRAME");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
