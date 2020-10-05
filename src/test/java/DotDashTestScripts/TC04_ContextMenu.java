package DotDashTestScripts;

import DotDashBase.baseClass;
import DotDashPages.ContextMenuPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/*Testcase Description: ContextMenu: http://localhost:7080/context_menu Right-click in the box to see one called 'the-internet'
 . Test JavaScript alert text on Right-Click.
 */

public class TC04_ContextMenu extends baseClass {

    @Test
    public void contextmenu()
    {
        //Launch url
        driver.get(baseURL+"/context_menu");

        //Create object of ContextMenuPage
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);

        //Create object of Actions class to right click on the box
        Actions act = new Actions(driver);
        act.contextClick(contextMenuPage.boxContext).build().perform();

        //Capture the alert message
        Alert alert = driver.switchTo().alert();

        SoftAssert assertion = new SoftAssert();
        if(alert.getText().contains("You selected a context menu"))
        {
            assertion.assertTrue(true);
            System.out.println("Test Passed");
        }
        else
        {
            assertion.assertTrue(false);
            System.out.println("Test Failed");

        }
        assertion.assertAll();

        //Click Ok to close the alert
        alert.accept();


    }

}
