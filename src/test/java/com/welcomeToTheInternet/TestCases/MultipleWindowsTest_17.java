package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.MultipleWindowsPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultipleWindowsTest_17 extends BaseClass {

    @Test
    public void MultipleWindowsTest() {
        driver.get(baseURL);
        MultipleWindowsPage multipleTabs = new MultipleWindowsPage(driver);

        multipleTabs.clickMultipleWindowLink();
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "Opening a new window");
        multipleTabs.clickOpenNewWindowLink();
        multipleTabs.checkNewWindowTab(); // assertion in the MultipleWindowsPage class
    }
}
