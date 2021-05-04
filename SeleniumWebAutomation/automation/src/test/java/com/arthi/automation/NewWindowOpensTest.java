package com.arthi.automation;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.arthi.automation.common.TestBase;
import com.arthi.pageobjects.NewWindowOpenPage;


/**
 * 
 * @author Arthina Kumar
 *
 */
public class NewWindowOpensTest extends TestBase {
	
	@Test
	public void check_New_Window_Event() throws AWTException{
		NewWindowOpenPage newWindowOpenPage =  new NewWindowOpenPage(getDriver());
		newWindowOpenPage.navigateToNewWindowOpenPage()
		.checkWindowEvents();
	}
	

}
