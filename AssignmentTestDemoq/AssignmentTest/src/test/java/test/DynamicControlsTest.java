package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.DynamicControlsPage;

public class DynamicControlsTest extends TestBaseAssignment {
	
	@Test
	@Parameters({"DynamicControlUrl"})
	public void RemoveButtonAndExplicitWaitTestCase(String DynamicControlUrl) throws InterruptedException{
		this.helper.getDriver().get(DynamicControlUrl);
		this.helper.maximizeWindows();
		
		DynamicControlsPage dp= new DynamicControlsPage(this.helper.getDriver(), helper);
		
		   //click remove button and using explicit wait
           dp.clickButton("Add/Remove Button","It's gone!");
           // verify check box is disabled
           dp.VerifyCheckboxDoesNotExists("CheckBox");
           
           //click add button and using explicit wait
           dp.clickButton("Add/Remove Button","It's back!");
           // verify check box is enabled
           dp.VerifyCheckboxExists("CheckBox");
	}	
	
	@Test
	@Parameters({"DynamicControlUrl"})
	public void EnableDisableAndExplicitWaitTestCase(String DynamicControlUrl) throws InterruptedException{
		this.helper.getDriver().get(DynamicControlUrl);
		this.helper.maximizeWindows();
		
		DynamicControlsPage dp= new DynamicControlsPage(this.helper.getDriver(), helper);
		
		//Click Enable button
		dp.clickButton("Enable Button", "Disable");
		// Verify text box is enabled
		dp.VerifyTextBoxIsEnabled("It's enabled!");
		
		// Click Disable button
		dp.clickButton("Disable Button", "Enable");
		// Verify text box is disable
		dp.VerifyTextBoxIsDisabled("It's disabled!");
	}
	
		

}
