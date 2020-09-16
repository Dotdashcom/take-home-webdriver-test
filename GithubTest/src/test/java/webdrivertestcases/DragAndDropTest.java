package webdrivertestcases;

/*
 * In order to do the drag and drop I used the Actions class which is for
 * mouse movement and keyboard.
 * First, I have instantiate the action class by passing driver to its constructor.
 * Then, I have invoked the dragAndDrop() method by passing the source and target webelemnts.
 * Finally, I have used build and perform to execute all the steps.
 * */

import common.Base;
import org.testng.Assert;
import org.testng.annotations.*;
import webdrivertestpages.DragAndDrop;


public class DragAndDropTest extends Base {
    @BeforeTest
    public void setup(){
        driver = getDriver();
        driver.get(baseURI + "/drag_and_drop");
    }

    @Test
    public void dragAndDropTest(){
        DragAndDrop dad = new DragAndDrop(driver);
        dad.dragAndDrop();

        //verify text changed in to 'B' box
        Assert.assertTrue(dad.isDropped());
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
