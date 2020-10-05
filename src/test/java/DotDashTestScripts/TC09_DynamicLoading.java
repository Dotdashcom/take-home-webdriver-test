package DotDashTestScripts;

import DotDashBase.baseClass;
import DotDashPages.DynamicLoadingPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
//Testcase Description: Dynamic Loading: http://localhost:7080/dynamic_loading/2 Test Dynamic Loading using Explict Waits.
public class TC09_DynamicLoading extends baseClass {
    @Test
    public void dynamicLoading()
    {
        //Launch url
        driver.get(baseURL+"/dynamic_loading/2");

        //Create an object for DynamicLoadingPage
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);

        //Click on Start button
        dynamicLoadingPage.clkbtnStart();

        //Assert whether Hello World is displayed
        SoftAssert assertion = new SoftAssert();
        if(dynamicLoadingPage.gettxtMessage().equals("Hello World!"))
        {
            assertion.assertTrue(true);
            System.out.println("Test Passed!! Hello World! is displayed");
        }
        else
        {
            assertion.assertTrue(false);
            System.out.println("Test Failed!! Hello World! NOT displayed");
        }
        assertion.assertAll();


    }
}
