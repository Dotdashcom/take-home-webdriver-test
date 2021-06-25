package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DragAndDropPage;
import utilities.BrowserUtils;
import utilities.EndPoints;



public class DragAndDrop extends TestBase{

    @Test
    public void testDragAndDrop() {
        DragAndDropPage dad = new DragAndDropPage();
        extentTest = extentReports.createTest("Drag And Drop");
        dad.navigateTo(EndPoints.DRAGANDDROP);
        extentTest.info("Navigate To Drag And Drop Page");

        Actions actions = new Actions(dad.driver);
        BrowserUtils.wait(3);
        actions.clickAndHold(dad.a).moveToElement(dad.b).release(dad.a).perform();
        BrowserUtils.wait(3);
        extentTest.info("Drag Element Dragged to the Source");

        Assert.assertEquals(dad.a.getText(),"B");
        Assert.assertEquals(dad.b.getText(),"A");
        extentTest.info("Verify A and B are changed");

        extentTest.pass("Message is verified ");

    }
}
