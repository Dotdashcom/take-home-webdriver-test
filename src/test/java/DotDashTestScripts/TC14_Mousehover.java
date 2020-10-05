package DotDashTestScripts;

import DotDashBase.baseClass;
import DotDashPages.MouseHoverPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;

//TestCase Description: Mouse Hover: http://localhost:7080/hovers Test Mouse Hover.
public class TC14_Mousehover extends baseClass {

    @Test
    public void mouseHover() throws InterruptedException {
        //Launch url
        driver.get(baseURL+"/hovers");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        //Create an object for MouseHoverPage
        MouseHoverPage mouseHoverPage = new MouseHoverPage(driver);

        //Actions class to perform mouse hover action
        Actions act = new Actions(driver);

        //Hover the mouse over each image and validate whether additional information is displayed
        SoftAssert assertion = new SoftAssert();

       /* for(WebElement img : mouseHoverPage.imgs)
        {
            Thread.sleep(2000);
            act.moveToElement(img).build().perform();
            if(mouseHoverPage.captions.isDisplayed())
            {
                System.out.println("Test Pass");
            }
            else
            {
                System.out.println("Test Fail");
            }
        }*/


       act.moveToElement(mouseHoverPage.img1).build().perform();
        if(mouseHoverPage.caption1.isDisplayed())
        {
            assertion.assertTrue(true);
            System.out.println("Test Passed!! Additional info displayed!!!");
        }
        else
        {
            assertion.assertTrue(false);
            System.out.println("Test Failed!! NO Additional info displayed!!!");
        }

        act.moveToElement(mouseHoverPage.img2).build().perform();
        if(mouseHoverPage.caption2.isDisplayed())
        {
            assertion.assertTrue(true);
            System.out.println("Test Passed!! Additional info displayed!!!");
        }
        else
        {
            assertion.assertTrue(false);
            System.out.println("Test Failed!! NO Additional info displayed!!!");
        }

        act.moveToElement(mouseHoverPage.img3).build().perform();
        if(mouseHoverPage.caption3.isDisplayed())
        {
            assertion.assertTrue(true);
            System.out.println("Test Passed!! Additional info displayed!!!");
        }
        else
        {
            assertion.assertTrue(false);
            System.out.println("Test Failed!! NO Additional info displayed!!!");
        }

        assertion.assertAll();

    }
}
