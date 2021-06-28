package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.MultipleWindowsPage;
import org.testng.annotations.Test;

public class MultipleWindowsTest_17 extends BaseClass {

    @Test
    public void MultipleWindowsTest() {
        driver.get(baseURL);
        MultipleWindowsPage multipleTabs = new MultipleWindowsPage(driver);

        multipleTabs.clickMultipleWindowLink();
        multipleTabs.clickOpenNewWindowLink();
        multipleTabs.checkNewWindowTab();
    }
}
