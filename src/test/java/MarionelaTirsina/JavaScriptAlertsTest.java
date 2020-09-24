package MarionelaTirsina;

;

import MarionelaTirsina.pages.JavaScriptAlert;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class JavaScriptAlertsTest {
    //    JavaScript Alerts: http://localhost:7080/javascript_alerts
    //    Test confirm JS Alert.
    JavaScriptAlert JS= new JavaScriptAlert();
    @Before
    public void setUpMethod() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/javascript_alerts");
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }



    @Test
    public void javaScriptAlertTest() {
        WebElement JSAlertButton = JS.javaScripAlert;
        JSAlertButton.click();

        Alert alert = Driver.getDriver().switchTo().alert();
        String actAlertText = alert.getText();
        String expAlertText = "I am a JS Alert";
        Assert.assertEquals(expAlertText, actAlertText);
    }

    @Test
    public void JavaScriptConfirmTest() {
        WebElement JavaSriptConfirmButton = JS.JSconfirmButton;
        JavaSriptConfirmButton.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
        WebElement visibleText = JS.visibleText;

        Assert.assertTrue(visibleText.isDisplayed());
    }

    @Test
    public void JavaScriptPromptTest() {
        WebElement JavaScriptPromptButton = JS.JSpromtButton;
        JavaScriptPromptButton.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.sendKeys("Today it's a beautiful day!");
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        alert.accept();

        WebElement resultTest = JS.result;
        String actualText = resultTest.getText();
        String expectedTest = "Today it's a beautiful day!";
        Assert.assertTrue(actualText.contains(expectedTest));


    }
    @After
    public void tearDown() throws Exception{
        Thread.sleep(2000);
    }

}

