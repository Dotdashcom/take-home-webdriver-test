package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.JsAlertPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JsAlertTest_15 extends BaseClass {

    @Test
    public void JsAlertTest() {
        driver.get(baseURL);
        JsAlertPage jsAlertPage = new JsAlertPage(driver);

        jsAlertPage.clickJSAlertPageLink();
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "JavaScript Alerts");
        jsAlertPage.clickJsAlertButton(); // assertion in the JSAlertPage.class
        jsAlertPage.waitForAlert(driver);

        jsAlertPage.clickJsConfirmButton(); // assertion in the JSAlertPage.class
        jsAlertPage.waitForAlert(driver);

        jsAlertPage.clickJSPromptButton(); // assertion in the JSAlertPage.class
        jsAlertPage.waitForAlert(driver);
    }

}
