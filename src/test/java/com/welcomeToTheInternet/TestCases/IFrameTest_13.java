package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.IFramePage;
import org.testng.annotations.Test;

public class IFrameTest_13 extends BaseClass {

    @Test
    public void IFramePageTest() {
        driver.get(baseURL);
        IFramePage iFramePage = new IFramePage(driver);

        iFramePage.clickFramePageLink();
        iFramePage.clickIFramesPage();
        iFramePage.closeAlert();
        iFramePage.editText();
        iFramePage.checkText();
    }
}
