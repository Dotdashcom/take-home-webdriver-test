package webdrivertestcases;

import common.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import webdrivertestpages.JavaScriptAlert;
import webdrivertestpages.JavaScriptError;

public class JavaScriptErrorTest extends Base {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = getDriver();
        driver.get("http://localhost:7080/javascript_error");
    }

    @Test
    public void javaScriptError(){
        JavaScriptError js = new JavaScriptError(driver);
        Assert.assertEquals(js.javascriptError(), "http://localhost:7080/javascript_error 6:51 Uncaught TypeError: Cannot read property 'xyz' of undefined");

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
