package webdrivertestcases;

import common.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import webdrivertestpages.DynamicLoading;

public class DynamicLoadingTest extends Base {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = getDriver();
        driver.get("http://localhost:7080/dynamic_loading/2");
    }

    @Test
    public void dynamicLoadingTest(){
        DynamicLoading dl = new DynamicLoading(driver);
        dl.dynamicLoading();
        Assert.assertEquals(dl.getTxt(), "Hello World!");
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
