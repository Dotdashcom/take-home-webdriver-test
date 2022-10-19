package com.dotdash.tests;

import com.dotdash.pages.JSAlertsPage;
import com.dotdash.utilities.ConfigurationReader;
import com.dotdash.utilities.Driver;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test15_JavaScriptAlerts {

    /**
     * Test Clicks on JS Alert Button.
     * Test asserts alert message.
     * Test clicks on JS confirm Button and clicks ok on alert.
     * Test asserts the alert message.
     * Test clicks on JS Prompt Button and types a message on Prompt.
     * Test asserts that the alert message contains the typed message.
     */

    @Test
    public void javaScriptAlertsTest(){

        JSAlertsPage jsAlertsPage = new JSAlertsPage();

        String url = ConfigurationReader.getProperty("base.url") + "/javascript_alerts";
        Driver.getDriver().get(url);

        jsAlertsPage.alert.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS Alert");
        alert.accept();
        Assert.assertEquals(jsAlertsPage.result.getText(),"You successfuly clicked an alert");

        jsAlertsPage.confirm.click();
        alert = Driver.getDriver().switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS Confirm");
        alert.accept();
        Assert.assertEquals(jsAlertsPage.result.getText(),"You clicked: Ok");

        jsAlertsPage.prompt.click();
        alert = Driver.getDriver().switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am a JS prompt");
        alert.sendKeys("TEST message");
        alert.accept();
        Assert.assertEquals(jsAlertsPage.result.getText(),"You entered: TEST message");

        Driver.closeDriver();

    }

}
