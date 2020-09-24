package MarionelaTirsina;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class JavaScriptError {
    /**
     * JavaScript Error: http://localhost:7080/javascript_error Test JS error.
      */

    MarionelaTirsina.pages.JavaScriptError javaScriptError= new MarionelaTirsina.pages.JavaScriptError();
    @Before
    public void setUp() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/javascript_error");
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void JavaSriptErrorTest() {

        ExpectedCondition<Boolean> expectedResult = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
            wait.until(expectedResult);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }

    }
    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);

    }
}

