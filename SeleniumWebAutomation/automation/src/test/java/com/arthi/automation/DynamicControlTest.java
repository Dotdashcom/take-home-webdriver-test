package com.arthi.automation;

import org.testng.annotations.Test;

import com.arthi.automation.common.TestBase;
import com.arthi.pageobjects.DynamicControlsPage;

/**
 * 
 * @author Arthina Kumar
 *
 */

public class DynamicControlTest extends TestBase {
	
	@Test(priority=0, description="Verify the Dynamic Control Test")
	public void checkDynamicControlTest(){
		DynamicControlsPage dynamiccontrolPage =  new DynamicControlsPage(getDriver());
		dynamiccontrolPage.navigateToDynamicControlPage()
		.verifyRemoveEvent("It's gone!")
		.verifyEnableEvents();
		
		
	}
	 
	 

}
