package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.JavaScriptAlertsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class JavaScriptAlerts {

    JavaScriptAlertsPage javaScriptAlertsPage=new JavaScriptAlertsPage();
    @Test
    public void test(){
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl")+"javascript_alerts");

        javaScriptAlertsPage.alertButton.click();
        Driver.getDriver().switchTo().alert().accept();
        Assert.assertEquals(Driver.getDriver().switchTo().alert().getText(),"I am a JS alert");
        javaScriptAlertsPage.confirmButton.click();
        Assert.assertEquals(Driver.getDriver().switchTo().alert().getText(),"I am a JS Confirm");
        Driver.getDriver().switchTo().alert().accept();
        javaScriptAlertsPage.promptButton.click();
        Driver.getDriver().switchTo().alert().sendKeys("I am a JS prompt");
        String expectedMessage = "I am a JS prompt";
        Assert.assertTrue(javaScriptAlertsPage.resultText.getText().contains(expectedMessage));
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
