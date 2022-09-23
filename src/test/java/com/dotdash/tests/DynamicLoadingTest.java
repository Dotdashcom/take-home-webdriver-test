package com.dotdash.tests;

import com.dotdash.pages.DynamicLoadingPage;
import com.dotdash.pages.TestBase;
import com.dotdash.utilities.Driver;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingTest extends TestBase {

    @Test
    public void dynamicLoadingTest() {

        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();
        dynamicLoadingPage.navigatePages("Dynamic Loading");

        dynamicLoadingPage.linkOne.click();
        dynamicLoadingPage.start.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(dynamicLoadingPage.successMsg));

        Assertions.assertEquals("Hello World!", dynamicLoadingPage.successMsg.getText() );

    }

}
