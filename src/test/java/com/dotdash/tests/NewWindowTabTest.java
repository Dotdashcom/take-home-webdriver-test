package com.dotdash.tests;

import com.dotdash.pages.NewWindowTabPage;
import com.dotdash.pages.TestBase;
import com.dotdash.utilities.Driver;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Set;

public class NewWindowTabTest extends TestBase {


    @Test
    public void getWindowTabTest() {

        NewWindowTabPage newWindowTabPage = new NewWindowTabPage();
        newWindowTabPage.navigatePages("Multiple Windows");


        newWindowTabPage.clickHere.click();
        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();
        for (String each : allWindowsHandles) {
            Driver.getDriver().switchTo().window(each);
            System.out.println("driver.getTitle() = " + Driver.getDriver().getTitle());
        }
        String expectedTitleAfterClicking = "New Window";
        String actualTitle = Driver.getDriver().getTitle();
        Assertions.assertEquals(actualTitle, expectedTitleAfterClicking);


    }


}
