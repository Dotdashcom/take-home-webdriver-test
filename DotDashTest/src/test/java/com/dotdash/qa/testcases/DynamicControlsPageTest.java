package com.dotdash.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dotdash.qa.base.TestBase;
import com.dotdash.qa.pages.DynamicControlsPage;

public class DynamicControlsPageTest extends TestBase {
	
	DynamicControlsPage dynamicControlsPage;
	
	
	
	@BeforeMethod
	public void setup(){
		initialization("/dynamic_controls");
		dynamicControlsPage = new DynamicControlsPage();
	}
	
	@Test(priority = 1)
	public void dynamicCheckBoxTest() {
		
		boolean b1 = dynamicControlsPage.removeCheckBox();
		Assert.assertTrue(b1, "Dynamic check box Test case is passed");
		boolean b2 = dynamicControlsPage.enableTextBox();
		Assert.assertTrue(b2, "Dynamic Text Box Test case is passed");
	}

}
