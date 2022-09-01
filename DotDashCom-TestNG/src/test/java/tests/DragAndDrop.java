package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.DragDropPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class DragAndDrop {
    DragDropPage dragDropPage = new DragDropPage();

    @Test()
    public void test01() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("baseUrl") + "drag_and_drop"); //Go to "http://localhost:7080/drag_and_drop" URL
        ReusableMethods.waitForPageToLoad(3); //Page load waiting for 3 seconds

        Actions actions = new Actions(Driver.getDriver());
        ReusableMethods.waitFor(3);
        actions.dragAndDrop(dragDropPage.columnA, dragDropPage.columnB).build().perform();
        //actions.clickAndHold(dragDropPage.columnA).moveToElement(dragDropPage.columnB).release(dragDropPage.columnA).perform();

        ReusableMethods.waitFor(3);

        Assert.assertEquals(dragDropPage.columnA.getText(),"B");
        Assert.assertEquals(dragDropPage.columnB.getText(),"A");

    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
