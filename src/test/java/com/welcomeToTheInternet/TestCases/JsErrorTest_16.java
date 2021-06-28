package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.JsErrorPage;
import org.testng.annotations.Test;

public class JsErrorTest_16 extends BaseClass {

    @Test
    public void JsErrorTest() {
        driver.get(baseURL);
        JsErrorPage jsErrorPage = new JsErrorPage(driver);

        jsErrorPage.clickJsErrorPageLink();
        jsErrorPage.checkJsError();
    }
}
