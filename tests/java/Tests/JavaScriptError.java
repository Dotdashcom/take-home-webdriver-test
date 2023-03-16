package Tests;

import Tests.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class JavaScriptError {
    @BeforeTest
    public void setup(){
    }
    @AfterTest
    public void teardown() {
        Driver.closeDriver();
    }
    @Test
    public void JavaScriptError() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        Driver.getDriver().get("http://localhost:7080/javascript_error");
        WebElement errorMsg = Driver.getDriver().findElement(By.xpath("//body[@onload='loadError()']"));
        assertTrue(errorMsg.getText().contains("JavaScript error"));
    }
}
