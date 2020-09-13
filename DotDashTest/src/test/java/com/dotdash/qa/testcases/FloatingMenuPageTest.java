package com.dotdash.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.qa.base.TestBase;
import com.dotdash.qa.pages.FloatingMenuPage;

public class FloatingMenuPageTest extends TestBase{
	
	FloatingMenuPage floatingMenuPage;
	
	@BeforeMethod
	public void setup(){
		initialization("/floating_menu");
		floatingMenuPage = new FloatingMenuPage();
	}
	
	@Test(priority = 1)
	public void floatingMenuTest() {
		
		boolean b = floatingMenuPage.floatingMenu();
		Assert.assertTrue(b, "Test case is not passed");
	}

}
