package webdrivertestcases;


/*
 * In order to do the right click I will use the Actions class which is basically use
 * for mouse movement and key board.
 * Then, I will create an instant of the Actions class by passing the driver to its constructor.
 * Then, I will invoke the contextClick() method by passing the webelement and
 * I will also have to invoke the perform() method
 *
 * */

import common.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import webdrivertestpages.ContextMenu;

/*
 * In order to handle the pop up I am using the Alert interface.
 * Then, I am invoking accept() method which will click on the "OK" button
 * as soon as the pop up appears.
 * */
public class ContextMenuTest extends Base {
    WebDriver driver;
    @BeforeTest
    public void setup(){
        driver = getDriver();
        driver.get("http://localhost:7080/context_menu");
    }

    @Test
    public void contextMenuTest(){
        ContextMenu cm = new ContextMenu(driver);
        cm.contextMenu();

        Assert.assertEquals(cm.alertHandler(), "You selected a context menu");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
