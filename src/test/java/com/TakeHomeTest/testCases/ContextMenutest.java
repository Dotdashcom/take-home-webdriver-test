package com.TakeHomeTest.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.TakeHomeTest.pageObjects.ContextMenuPageObjects;

public class ContextMenutest extends BaseClass {

	@Test
	public void right_click() {
		ContextMenuPageObjects pageobj=new ContextMenuPageObjects(driver);
		driver.get(url+"/context_menu");
		pageobj.right_click();
		
		String alert_text=driver.switchTo().alert().getText();
		Assert.assertEquals(alert_text, "You selected a context menu");
		driver.switchTo().alert().accept();
	}
}
