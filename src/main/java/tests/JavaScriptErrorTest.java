package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.utils;

public class JavaScriptErrorTest {
	

    @Test
    public void jsErrorTest()  {
        WebDriver driver = TestBase.getInstance().getDriver();
        driver.get(utils.url + "/javascript_error");
        
        LogEntries jsErrors = driver.manage().logs().get(LogType.BROWSER);
        System.out.println(jsErrors.getAll().get(0).toString());

        try {      
  
            Assert.assertTrue(jsErrors.getAll().get(0).toString().contains("Cannot read properties of undefined (reading 'xyz')"));
            System.out.println("passed");
        } catch (AssertionError e) {
            System.out.println("failed");
            throw e;
        }
    }

    @AfterTest
    public void teardown() {
        TestBase.getInstance().getDriver().quit();
    }
}



