package webdrivertestcases;

import common.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import webdrivertestpages.DropDownList;

/*
 * In order to do the drop down I used the Select class of Selenium WebDriver.
 * First, I have instantiated the Select class by passing the element to its constructor.
 * Then, I have invoked the selectByVisibleText() method to select an option based on the
 * text over the option which is "Option1"
 * */
public class DropDownListTest extends Base {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = getDriver();
        driver.get(baseURI + "/dropdown");
    }

    @Test
    public void dropDownListTest(){
        DropDownList dl = new DropDownList(driver);
        dl.dropDownList();
        Assert.assertEquals(dl.dropDownList(), "Option 1");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
