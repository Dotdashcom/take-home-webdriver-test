package webdrivertestcases;

import common.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import webdrivertestpages.FloatingMenu;
import webdrivertestpages.LoginSuccess;

public class FloatingMenuTest extends Base {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = getDriver();
        driver.get("http://localhost:7080/floating_menu");
    }

    @Test
    public void floatingMenu(){
        FloatingMenu fm = new FloatingMenu(driver);
        fm.floatingMenu();
        Assert.assertEquals(fm.getCurrentURlAfterScrollDown(), "http://localhost:7080/floating_menu#news");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
