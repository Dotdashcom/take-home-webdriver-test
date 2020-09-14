package webdrivertestcases;

import common.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import webdrivertestpages.DynamicContent;

/*
 * I can basically check the dynamic content that changes in every reload
 * by refreshing the page.
 * To do that I am using navigate().refresh() methods which refresh the page
 * */

public class DynamicContentTest extends Base {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = getDriver();
        driver.get("http://localhost:7080/dynamic_content");
    }

    @Test
    public void dynamicContentTest(){
        DynamicContent dc = new DynamicContent(driver);
        Assert.assertTrue(dc.dynamicContent());
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
