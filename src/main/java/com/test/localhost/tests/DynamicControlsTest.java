package com.test.localhost.tests;

import com.test.localhost.pages.DynamicControlsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicControlsTest extends TestBase {

    @Test
    public void dynamicControlsTest(){
        DynamicControlsPage dynamicControlsPage=new DynamicControlsPage(driver);
        dynamicControlsPage.clickDynamicControlsButton();
        dynamicControlsPage.clickRemoveButton();
        Assert.assertEquals(dynamicControlsPage.getMessage(driver),"It's gone!");
        dynamicControlsPage.clickAddButton();
        Assert.assertEquals(dynamicControlsPage.getMessage(driver),"It's back!");
        dynamicControlsPage.clickEnableButton();
        Assert.assertEquals(dynamicControlsPage.getMessage(driver),"It's enabled!");
        dynamicControlsPage.clickDisableButton();
        Assert.assertEquals(dynamicControlsPage.getMessage(driver),"It's disabled!");
    }

}
