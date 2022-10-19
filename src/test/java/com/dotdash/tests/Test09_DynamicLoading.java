package com.dotdash.tests;

import com.dotdash.pages.DynamicLoadingPage;
import com.dotdash.utilities.ConfigurationReader;
import com.dotdash.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test09_DynamicLoading {

    /**
     * Test clicks the start button and uses explicit wait.
     * Test asserts that “Hello World!” text is displayed.
     */

    @Test
    public void dynamicLoadingTest() {

        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage();

        String url = ConfigurationReader.getProperty("base.url") + "/dynamic_loading/2";
        Driver.getDriver().get(url);

        dynamicLoadingPage.startBtn.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(dynamicLoadingPage.loading));

        Assert.assertEquals(dynamicLoadingPage.displayedText.getText(),"Hello World!");

        Driver.closeDriver();
    }

}
