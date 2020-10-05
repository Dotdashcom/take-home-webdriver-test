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
        if(dynamicControlsPage.gettxtmsg().equals("It's gone!"))
        {
            assertion.assertTrue(true);
            System.out.println("Test Passed!! Remove button is Gone!!");
        }
        else
        {
            assertion.assertTrue(false);
            System.out.println("Test Failed!! Remove button is Not Gone!!");
        }

        //Click on Add button
        dynamicControlsPage.clkbtnAdd();

        //Validate if the checkbox is present
        if(dynamicControlsPage.chkboxisDisplayed())
        {
            assertion.assertTrue(true);
            System.out.println("Test Passed!! Checkbox is back!!");
        }
        else
        {
            assertion.assertTrue(false);
            System.out.println("Test Failed!! Checkbox is missing!!");
        }
        //Check whether textbox is enabled before clicking on Enable button
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
        if(dynamicControlsPage.txtboxisNowEnabled())
        {
            assertion.assertTrue(true);
            System.out.println("Test Passed!! Textbox is Now enabled !!");
        }
        else
        {
            assertion.assertTrue(false);
            System.out.println("Test Failed!! Textbox is NOT enabled !!");
        }

        //Click on Disable button
        dynamicControlsPage.clkbtnDisable();

        //Not preferred but in this case, Textbox is taking longer than usual to actually become disble
        Thread.sleep(4000);

        //Validate whether the textbox is disabled
        if(!dynamicControlsPage.txtboxisEnabled())      //Textbox is not enabled
        {
            assertion.assertTrue(true);
            System.out.println("Test Passed!! Textbox is finally Disabled !!");
        }
        else
        {
            assertion.assertTrue(false);
            System.out.println("Test Failed!! Textbox is still Enabled !!");
        }



        assertion.assertAll();
    }
}
