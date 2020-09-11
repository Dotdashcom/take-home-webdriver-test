package QatestsMatif;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import browserUtil.Driver;
import browserUtil.ConfigReader;

import java.util.concurrent.TimeUnit;

public class JavaScriptErrorTest {
    @BeforeMethod
    public void setUpMethod() {

        Driver.get().get(browserUtil.ConfigReader.get("baseUrl") + "/javascript_error");
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }


    @Test
    public void JSError() {

        ExpectedCondition<Object> expectation = new ExpectedCondition<Object>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(2000);
            WebDriverWait wait = new WebDriverWait(Driver.get(), 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
    }

}

