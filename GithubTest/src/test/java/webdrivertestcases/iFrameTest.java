package webdrivertestcases;

import common.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import webdrivertestpages.iFrame;

public class iFrameTest extends Base {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = getDriver();
        driver.get("http://localhost:7080/iframe");
    }

    @Test
    public void iframehandler(){
        iFrame fm = new iFrame(driver);
        fm.iFrameHandle();
        Assert.assertEquals(fm.getMessageToBody(), "Your content goes here.");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
