package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.DynamicLoadedElementsPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class DynamicLoadingTest_9 extends BaseClass{

    @Test
    public void DynamicLoadedElementsTest() throws IOException {
        driver.get(baseURL);
        DynamicLoadedElementsPage dynamicLoaded = new DynamicLoadedElementsPage(driver);

        dynamicLoaded.clickDynamicLoadingLink();
        dynamicLoaded.clickLinkElementHidden();
        dynamicLoaded.clickHiddenButton();
        dynamicLoaded.waitForText();

        driver.navigate().back();
        dynamicLoaded.clickLinkElementRendered();
        dynamicLoaded.clickRenderedButton();
        dynamicLoaded.waitForText();
    }
}
