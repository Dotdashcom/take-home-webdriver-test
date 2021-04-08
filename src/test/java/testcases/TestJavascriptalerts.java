package testcases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import pages.JavascriptAlertsPage;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.Driver;


public class TestJavascriptalerts {
    JavascriptAlertsPage javascriptAlertsPage = new JavascriptAlertsPage();

    @Before
    public void setUp() {
        String url = ConfigReader.readProperty("url") + "javascript_alerts";
        Driver.getDriver().get(url);
    }

    @Test
    public void testAlerts() {

        BrowserUtils.highlightElement(javascriptAlertsPage.JSalert);
        javascriptAlertsPage.JSalert.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        String jsAlert = Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals("I am a JS Alert", jsAlert);
        alert.accept();
        Assert.assertTrue(javascriptAlertsPage.result.getText().equals("You successfuly clicked an alert"));

        BrowserUtils.highlightElement(javascriptAlertsPage.JSconfirm);
        javascriptAlertsPage.JSconfirm.click();
        String jsConfirm = Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals("I am a JS Confirm", jsConfirm);
        alert.dismiss();
        Assert.assertTrue(javascriptAlertsPage.result.getText().equals("You clicked: Cancel"));

        BrowserUtils.highlightElement(javascriptAlertsPage.JSprompt);
        javascriptAlertsPage.JSprompt.click();
        String jsPrompt = Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals("I am a JS prompt", jsPrompt);
        alert.sendKeys("Hello");
        alert.accept();
        Assert.assertTrue(javascriptAlertsPage.result.getText().equals("You entered: Hello"));

    }
    @After
    public void tearDown() {
        Driver.quitDriver();
    }
}
