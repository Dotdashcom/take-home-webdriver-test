package test;

import Utilities.CommonMethods;
import Utilities.ConfigReader;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_015_JavaScriptAlerts extends CommonMethods {

    String result;
    Alert alert;
    String alertText;

    @BeforeMethod
    public void launchBrowser() {
        init_Driver(ConfigReader.getInput("browser"));
        getDriver().get("http://localhost:7080/javascript_alerts");
    }

    @Test(priority = 1)
    public void TC001_JsAlert() {
        selectExactObj(jsa.button(), "Click for JS Alert");
        alert = getDriver().switchTo().alert();
        alertText = alert.getText();
        Assert.assertTrue(alertText.contains("JS Alert"));
        acceptAlert();

        result = mh.jsa.getResult().getText();
        Assert.assertTrue(result.contains("clicked an alert"));
    }

    @Test(priority = 2)
    public void TC002_JsConfirmed() {
        selectExactObj(jsa.button(), "Click for JS Confirm");
        alert = getDriver().switchTo().alert();
        alertText = alert.getText();
        acceptAlert();

        result = mh.jsa.getResult().getText();
        Assert.assertTrue(result.contains("Ok"));
    }

    @Test(priority = 3)
    public void TC003_JsPrompt() {
        selectExactObj(jsa.button(), "Click for JS Prompt");
        alert = getDriver().switchTo().alert();
        alert.sendKeys("Hello World");
        acceptAlert();
        result = mh.jsa.getResult().getText();
        Assert.assertTrue(result.contains("Hello World"));
    }

    @AfterMethod
    public void destroy() {
        tearDown();
    }
}
