package com.DotDash.Scripts;

import com.DotDash.Pages.DynamicLoadingPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.DotDash.BasePage.basePage;
public class DynamicLoading extends basePage {
    @Test
    public void dynamicLoading() {
        driver.get(baseURL + "/dynamic_loading/2");

        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);

        dynamicLoadingPage.clkbtnStart();

        SoftAssert assertion = new SoftAssert();
        assertion.assertEquals(dynamicLoadingPage.gettxtMessage(), "Hello World!");

        assertion.assertAll();
    }
}
