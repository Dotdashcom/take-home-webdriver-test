package com.arthi.automation;

import org.testng.annotations.Test;

import com.arthi.automation.common.TestBase;
import com.arthi.pageobjects.MouseHoverPage;


/**
 * 
 * @author Arthina Kumar
 *
 */
public class MouseHoverTest extends TestBase {
	
	@Test
	public void  check_Mouse_Hover_Event_Test() throws InterruptedException{
		MouseHoverPage mousehoverPage = new MouseHoverPage(getDriver());
		mousehoverPage.navigateToMouseHoverPage()
		.checkMouseEvent();
			
	}
	
}
