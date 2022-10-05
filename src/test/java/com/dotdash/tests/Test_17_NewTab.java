package com.dotdash.tests;

import com.dotdash.base.TestBase;
import com.dotdash.pages.NewWindowTabsPage;
import com.dotdash.utilities.DriverUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.Set;

public class Test_17_NewTab extends TestBase {
    @Test
    public void get_tab_test() {

        NewWindowTabsPage newWindowTabPage = new NewWindowTabsPage();
        newWindowTabPage.navigatePages("Multiple Windows");


        newWindowTabPage.clickHere.click();
        Set<String> allWindowsHandles = DriverUtils.getDriver().getWindowHandles();
        for (String each : allWindowsHandles) {
            DriverUtils.getDriver().switchTo().window(each);
        }
        String expectedTitleAfterClicking = "New Window";
        String actualTitle = DriverUtils.getDriver().getTitle();
        Assertions.assertEquals(actualTitle, expectedTitleAfterClicking);


    }

}
