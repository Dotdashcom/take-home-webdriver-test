package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.HoversPage;
import org.testng.annotations.Test;

public class MouseHoverTest_14 extends BaseClass {

    @Test
    public void HoversPageTest() {
        driver.get(baseURL);
        HoversPage hoversPage = new HoversPage(driver);

        hoversPage.clickHoversPageLink();
        hoversPage.hoverOnImage1();
        hoversPage.checkText1();
        hoversPage.hoverOnImage2();
        hoversPage.checkText2();
        hoversPage.hoverOnImage3();
        hoversPage.checkTex3();
    }
}
