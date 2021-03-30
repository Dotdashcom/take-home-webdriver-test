package com.DotDash.Scripts;

import com.DotDash.Pages.JSAlertsPage;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.DotDash.BasePage.basePage;
public class JSAlerts extends basePage {

    @Test
    public void JSAlerts() {
        driver.get(baseURL + "/javascript_alerts");

        JSAlertsPage jsAlertsPage = new JSAlertsPage(driver);

        jsAlertsPage.clkbtnJSAlert();

        Alert alert = driver.switchTo().alert();

        alert.accept();

        SoftAssert assertion = new SoftAssert();
        assertion.assertTrue(jsAlertsPage.gettxtresult().contains("You successfuly clicked an alert"));


        jsAlertsPage.clkbtnJSConfirm();

        alert.accept();

        assertion.assertTrue(jsAlertsPage.gettxtresult().contains("Ok"));


        jsAlertsPage.clkbtnJSConfirm();

        alert.dismiss();

        assertion.assertTrue(jsAlertsPage.gettxtresult().contains("Cancel"));


        jsAlertsPage.clkbtnJSPrompt();
        String typedmsg = "Javascript is a scripting language!!";
        alert.sendKeys(typedmsg);

        alert.accept();
        assertion.assertTrue(jsAlertsPage.gettxtresult().contains(typedmsg));

        assertion.assertAll();
    }
}
