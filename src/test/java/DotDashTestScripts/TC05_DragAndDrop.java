package DotDashTestScripts;

import DotDashBase.baseClass;
import DotDashPages.DragandDropPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

//Testcase Description: Drag and Drop: http://localhost:7080/drag_and_drop Perofrm Drag And Drop in a Webdriver test.
public class TC05_DragAndDrop extends baseClass {

    @Test
    public void dragAnddrop() {
        //Launch the url
        driver.get(baseURL+"/drag_and_drop");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        //Create object of DragandDropPage
        DragandDropPage dragandDropPage = new DragandDropPage(driver);

        //Print the values before switching
        System.out.println("Before the drag and drop option:");
        System.out.println("Header Value of First box: "+dragandDropPage.getheaderA());
        System.out.println("Header Value of Second box: "+dragandDropPage.getheaderB());

        //Actions class to drag and drop operation
        Actions act = new Actions(driver);
        //act.dragAndDrop(dragandDropPage.boxColumnA,dragandDropPage.boxColumnB).build().perform();
        act.clickAndHold(dragandDropPage.boxColumnA).moveToElement(dragandDropPage.boxColumnB).release().build().perform();

        /*act.moveToElement(dragandDropPage.headerA).clickAndHold();
        act.moveToElement(dragandDropPage.headerB).release(dragandDropPage.headerA);
        act.build().perform();*/

        SoftAssert assertion = new SoftAssert();
        System.out.println("After the drag and drop option:");
        System.out.println("Header Value of First box: "+dragandDropPage.getheaderA());
        System.out.println("Header Value of Second box: "+dragandDropPage.getheaderB());

        //Validate whether the switch has happened
        assertion.assertTrue(dragandDropPage.getheaderA().equals("B") && dragandDropPage.getheaderB().equals("A"));

        assertion.assertAll();
    }
}
