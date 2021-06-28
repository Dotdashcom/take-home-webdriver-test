package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.JsAlertPage;
import org.testng.annotations.Test;

public class JsAlertTest_15 extends BaseClass {

    @Test
    public void JsAlertTest() {
        driver.get(baseURL);
        JsAlertPage jsAlertPage = new JsAlertPage(driver);

        jsAlertPage.clickJSAlertPageLink();
        jsAlertPage.clickJsAlertButton();
        jsAlertPage.waitForAlert(driver);
        jsAlertPage.clickJsConfirmButton();
        jsAlertPage.waitForAlert(driver);
        jsAlertPage.clickJSPromptButton();
        jsAlertPage.waitForAlert(driver);
    }

}
