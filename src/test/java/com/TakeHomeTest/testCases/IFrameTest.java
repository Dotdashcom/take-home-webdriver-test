package com.TakeHomeTest.testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.TakeHomeTest.pageObjects.IFramePageObjects;


public class IFrameTest extends BaseClass{

	@Test
	public void frametest() {
		IFramePageObjects framepage=new IFramePageObjects(driver);
		driver.get(url+"/iframe");
		
		/*int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		driver.switchTo().frame(0);*/

		driver.switchTo().frame("mce_0_ifr");//switch by frameID
		
		
		System.out.println("I am inside frame");
		String enteredframetext=framepage.WriteText();
		Assert.assertEquals(enteredframetext, "inside frame text");
	}
}
