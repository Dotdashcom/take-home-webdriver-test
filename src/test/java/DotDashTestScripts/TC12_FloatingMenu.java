package DotDashTestScripts;

import DotDashBase.baseClass;
import DotDashPages.FloatingMenuPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//Testcase Description: Floating Menu: http://localhost:7080/floating_menu Test Floating Menu.
public class TC12_FloatingMenu extends baseClass {

    @Test
    public void floatingmenu()
    {
        //Launch url
        driver.get(baseURL+"/floating_menu");

        //Create an object for FloatingMenuPage
        FloatingMenuPage floatingMenuPage = new FloatingMenuPage(driver);
        //Validate whether floating menu is displayed before scrolling. This is not an assertion!
        if(floatingMenuPage.chkfloatingmenu())
        {
            System.out.println("Floating menu is displayed before Scrolling to the end of the page!!");
        }
        else
        {
            System.out.println("Floating menu NOT displayed!!");
        }

        //Scroll down to the bottom of the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        //Validate whether floating menu is still displayed after scrolling to the end of the page
        SoftAssert assertion = new SoftAssert();
        assertion.assertTrue(floatingMenuPage.chkfloatingmenu());

        assertion.assertAll();
    }
}
