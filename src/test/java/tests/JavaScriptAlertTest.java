package tests;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.JavaScriptAlert;

public class JavaScriptAlertTest extends TestBase {
    @Test
    public void test1() {
        driver.get("http://localhost:7080/javascript_alerts");
        JavaScriptAlert message = new JavaScriptAlert(driver);
        Assert.assertEquals(message.clickJSButton(driver), "I am a JS Alert");
        Alert alert = driver.switchTo().alert();
        message.alertOk(driver,alert);

        Assert.assertEquals(message.clickConfirm(driver), "I am a JS Confirm");
        //Alert alert = driver.switchTo().alert();
        message.acceptAlert(alert);

        message.sendMessage(driver, "Hi I'm Mery");
        Assert.assertTrue(message.isMessageDisplayed(driver).contains("Hi I'm Mery"));


    }


}
