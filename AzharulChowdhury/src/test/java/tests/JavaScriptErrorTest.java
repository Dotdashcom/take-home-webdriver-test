package tests;

import Utility.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScriptErrorTest {

    @BeforeTest
    public void setup(){
        Driver.setupDriver();
        Driver.getDriver().navigate().to("http://localhost:7080/javascript_error");
    }

    @Test
    public void javaScriptError() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String error = (String) js.executeScript("return window.jsErrors[0]");
        Assert.assertEquals(error, "Cannot read property 'xyz' of undefined");
    }


    @AfterTest
    public void done() {
        Driver.getDriver().quit();
    }
}
