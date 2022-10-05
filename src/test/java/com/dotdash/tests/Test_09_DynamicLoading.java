package com.dotdash.tests;


import com.dotdash.base.TestBase;
import com.dotdash.pages.LoadingPage;
import com.dotdash.utilities.DriverUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Test_09_DynamicLoading extends TestBase {
    @Test
    public void dynamic_loading_test() {

        LoadingPage dynamicLoadingPage = new LoadingPage();
        dynamicLoadingPage.navigatePages("Dynamic Loading");

        dynamicLoadingPage.linkOne.click();
        dynamicLoadingPage.start.click();

        WebDriverWait wait = new WebDriverWait(DriverUtils.getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(dynamicLoadingPage.successMsg));

        Assertions.assertEquals("Hello World!", dynamicLoadingPage.successMsg.getText());

    }

}
