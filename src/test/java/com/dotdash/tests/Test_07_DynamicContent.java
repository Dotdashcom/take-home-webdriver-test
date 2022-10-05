package com.dotdash.tests;


import com.dotdash.base.TestBase;
import com.dotdash.pages.DynamicContentPage;

import com.dotdash.utilities.DriverUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class Test_07_DynamicContent extends TestBase {
    @Test
    public void dynamic_content_test() {

        DynamicContentPage dynamicContentPage = new DynamicContentPage();
        dynamicContentPage.navigatePages("Dynamic Content");

        String text1 = dynamicContentPage.firstElement.getText();
        DriverUtils.getDriver().navigate().refresh();
        String text2 = dynamicContentPage.firstElement.getText();

        Assertions.assertNotEquals(text1, text2);

        DriverUtils.getDriver().navigate().refresh();
        String text3 = dynamicContentPage.firstElement.getText();

        Assertions.assertNotEquals(text1, text3);


    }
}
