package com.arthi.automation;

import org.testng.annotations.Test;

import com.arthi.automation.common.TestBase;
import com.arthi.pageobjects.ContextMenuPage;

/**
 * 
 * @author Arthina Kumar
 *
 */

public class ContextMenuTest  extends TestBase{
	
	
	@Test
	public void testContextmenuEvent() throws InterruptedException{
		ContextMenuPage contextmenupage =  new ContextMenuPage(getDriver());
		contextmenupage.navigateToCheckBoxPage().verifyContextMenuEvent();
		
		
	
	

	}
	
	

}
