package com.TakeHomeTest.testCases;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.TakeHomeTest.pageObjects.NewWindowPageObjects;


public class NewWindowTest extends BaseClass{

	@Test
	public void newwindow() {
		NewWindowPageObjects newwinpage=new NewWindowPageObjects(driver);
		driver.get(url+"/windows");
		
		newwinpage.Clicklink();
		
		String currentHandle= driver.getWindowHandle();
		Set<String> allwindowHandles=driver.getWindowHandles();
		Iterator<String> iterator=allwindowHandles.iterator();
		
		while(iterator.hasNext())
		{
			String newHandle=iterator.next();
			if(!currentHandle.equalsIgnoreCase(newHandle)) {
				driver.switchTo().window(newHandle);
			}
		}
		String newtext=newwinpage.checknewtabtext();
		Assert.assertEquals(newtext, "New Window");
	}
}
