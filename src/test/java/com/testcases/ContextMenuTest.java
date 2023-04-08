package com.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.base.Base;
import com.pages.ContentMenuPage;

public class ContextMenuTest extends Base {
	
	ContentMenuPage cmp;
	@BeforeMethod
	public void setUp() {
		initialization();
	    driver.findElement(By.linkText("Context Menu")).click();
	    cmp=new ContentMenuPage();
	
	}
	
	@Test
	public void verifyContextMenuOnRightClick() {
		
		cmp.rightClickContentMenu();
		cmp.explicitWait();
		Assert.assertEquals(cmp.getTheAlertMessag(),"You selected a context menu");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
