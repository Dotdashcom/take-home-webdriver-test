package DotDashTestScripts;

import DotDashBase.baseClass;
import DotDashPages.DynamicControlsPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//TestCase Description: Dynamic Controls: http://localhost:7080/dynamic_controls Test Dynamic Controls using Explicit Waits.
public class TC08_DynamicControls extends baseClass {
    @Test
    public void dynamicControls() throws InterruptedException {
        //Launch url
        driver.get(baseURL+"/dynamic_controls");

        //Create an object of DynamicControlsPage
        DynamicControlsPage dynamicControlsPage = new DynamicControlsPage(driver);

        //Click on remove button
        dynamicControlsPage.clkbtnRemove();

        SoftAssert assertion = new SoftAssert();
        //Validate the message after clicking on remove button
        assertion.assertEquals(dynamicControlsPage.gettxtmsg(),"It's gone!", "Test Passed!");

        //Click on Add button
        dynamicControlsPage.clkbtnAdd();

        //Validate if the checkbox is present
        assertion.assertTrue(dynamicControlsPage.chkboxisDisplayed(), "Test Passed!");

        //Check whether textbox is enabled before clicking on Enable button.This is not an assertion!
        if(dynamicControlsPage.txtboxisEnabled())
        {
            System.out.println("Textbox is already enabled !!");
        }
        else
        {
            System.out.println("Textbox is NOT enabled !!");
        }

        //Click on Enable button
        dynamicControlsPage.clkbtnEnable();

        //Validate whether textbox is enabled after clicking on Enable button
        assertion.assertTrue(dynamicControlsPage.txtboxisNowEnabled(), "Test Passed!");

        //Click on Disable button
        dynamicControlsPage.clkbtnDisable();

        //Not preferred but in this case, Textbox is taking longer than usual to actually become disble
        Thread.sleep(4000);

        //Validate whether the textbox is disabled
        assertion.assertFalse(dynamicControlsPage.txtboxisEnabled());

        assertion.assertAll();
    }
}
