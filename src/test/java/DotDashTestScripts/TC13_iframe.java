package DotDashTestScripts;

import DotDashBase.baseClass;
import DotDashPages.iframePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//Testcase Description: Iframe: http://localhost:7080/iframe Test iframe.
public class TC13_iframe extends baseClass {
    //String to be passed in the box
    String typedtxt = "Automation Testing!!";
    @Test
    public void iframe()
    {
        //Launch url
        driver.get(baseURL+"/iframe");

        //Switch to Frame
        driver.switchTo().frame("mce_0_ifr");

        //Create an object for iframePage
        iframePage ifrmpg = new iframePage(driver);

        //Clear the contents in the box
        ifrmpg.txtcontentbox.clear();

        //Enter the text in the box
        ifrmpg.setTxtcontentbox(typedtxt);

        //Validate whether the entered text is as expected
        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(ifrmpg.getenteredtxt(),typedtxt);


        assertion.assertAll();



    }
}
