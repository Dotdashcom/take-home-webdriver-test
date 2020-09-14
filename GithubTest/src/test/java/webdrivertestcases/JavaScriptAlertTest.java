package webdrivertestcases;

import common.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import webdrivertestpages.JavaScriptAlert;

/*
 * In order to user the alert pop up I used Alert interface.
 * So, first I switched to the alert window by switchTo().alert() methods
 * And, then I used following methods
 * accept() - to click on ok button
 * dismiss() - to click on cancel button
 * getText() - to get the text present on the alert
 * sendKeys() - to enter the text on the alert
 * Also I used TestNG assertEqual method to validate if
 * the actual and expected are equals, if not then test will not pass.
 * if it is then test will pass
 * */

public class JavaScriptAlertTest extends Base {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = getDriver();
        driver.get("http://localhost:7080/javascript_alerts");
    }

    @Test
    public void javaScriptAlert(){
        JavaScriptAlert js = new JavaScriptAlert(driver);
        js.javaScriptAl();
        Assert.assertEquals(js.getJsAlertTxt(), "I am a JS Alert");
        Assert.assertEquals(js.getJsConfirmTxt(), "I am a JS Confirm");
        Assert.assertEquals(js.getJsPromptTxt(), "I am a JS prompt");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
