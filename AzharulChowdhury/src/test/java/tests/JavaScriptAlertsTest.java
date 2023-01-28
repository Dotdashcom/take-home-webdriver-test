package tests;

import Utility.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScriptAlertsTest {

    @BeforeTest
    public void setup(){
        Driver.setupDriver();
        Driver.getDriver().navigate().to("http://localhost:7080/javascript_alerts");
    }

    @Test
    public void testJSAlerts() {
        Driver.getDriver().findElement(By.cssSelector("#content > div > ul > li:nth-child(1) > button")).click();
        Alert alert = Driver.getDriver().switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(alertText, "I am a JS Alert");
        alert.accept();
        Driver.getDriver().findElement(By.cssSelector("#content > div > ul > li:nth-child(2) > button")).click();
        String alertText2 = alert.getText();
        Assert.assertEquals(alertText2, "I am a JS Confirm");
        alert.accept();
        Driver.getDriver().findElement(By.cssSelector("#content > div > ul > li:nth-child(3) > button")).click();
        alert.sendKeys("test message");
        alert.accept();
        Assert.assertEquals(Driver.getDriver().findElement(By.id("result")).getText(), "You entered: test message");
    }


    @AfterTest
    public void done() {
        Driver.getDriver().quit();
    }
}
