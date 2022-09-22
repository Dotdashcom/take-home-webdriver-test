package com.dotdash.tests;

import com.dotdash.pages.DynamicContentPage;
import com.dotdash.pages.TestBase;
import com.dotdash.utilities.Driver;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class DynamicContentTest extends TestBase {

    @Test
    public void dynamicContentTest() {

        DynamicContentPage dynamicContentPage = new DynamicContentPage();
        dynamicContentPage.navigatePages("Dynamic Content");

        String text1 = dynamicContentPage.firstElement.getText();
        Driver.getDriver().navigate().refresh();
        String text2 = dynamicContentPage.firstElement.getText();

        Assertions.assertNotEquals(text1, text2);

        Driver.getDriver().navigate().refresh();
        String text3 = dynamicContentPage.firstElement.getText();

        Assertions.assertNotEquals(text1, text3);


    }


}
