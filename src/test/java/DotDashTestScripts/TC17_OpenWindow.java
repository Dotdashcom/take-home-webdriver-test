package DotDashTestScripts;

import DotDashBase.baseClass;
import DotDashPages.OpenWindowPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Set;
//Testcase Description: Open in New Tab: http://localhost:7080/windows Test Link Opens in new tab.
public class TC17_OpenWindow extends baseClass {

    @Test
    public void openWindow()
    {
        //Launch url
        driver.get(baseURL+"/windows");

        //Create an object for OpenWindowPage
        OpenWindowPage openWindowPage = new OpenWindowPage(driver);

        //Click on Click here link
        openWindowPage.setBtnClickhere();

        //Capturing all the handles
        Set<String> handles = driver.getWindowHandles();

        SoftAssert assertion = new SoftAssert();
        for(String handle : handles)
        {
            String title = driver.switchTo().window(handle).getTitle();
          //  System.out.println(title);

            if(title.equals("New Window"))
            {
                //Validating whether a new tab is opened with New Window text
                if(openWindowPage.gettxtNewWindow()==true)
                {
                   assertion.assertTrue(true);
                   System.out.println("Test Passed!! New tab is opened with text New Window");
                }
                else
                {
                    assertion.assertTrue(false);
                    System.out.println("Test Failed!!No such text present!!");
                }

            }
            assertion.assertAll();


        }
    }
}
