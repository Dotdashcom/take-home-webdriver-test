package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.DriverUtilities;


public class JavaScriptErrorTest extends DriverUtilities {
    @Before
    public void setUp() {
        createDriver();
        getDriver().navigate().to("http://localhost:7080/javascript_error");
    }
    @Test
    public void jsError(){
        WebDriver driver = getDriver();
        WebElement error = driver.findElement(By.xpath("//p[contains(text(),'This page has a JavaScript error in the onload eve')]"));
        System.out.println(error.getText());
        String expectedError = "Cannot read property 'xyz' of undefined.";
        String actualError = error.getText();

        Assert.assertEquals(actualError,expectedError, "error message does not match");
    }


    @After
    public void cleanUp() {
        quitDriver();
    }
}


