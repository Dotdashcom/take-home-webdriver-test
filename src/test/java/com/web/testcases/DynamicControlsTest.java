package com.web.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.web.base.TestBase;
import com.web.pages.DynamicControlsPage;

import java.time.Duration;


public class DynamicControlsTest extends TestBase{

    DynamicControlsPage dynamicControlsPage;

    public DynamicControlsTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        driver.get("http://localhost:7080/dynamic_controls");
        dynamicControlsPage = new DynamicControlsPage();
    }


    @Test()
    public void verifyPageDynamicControls() throws InterruptedException {
        dynamicControlsPage.clickRemoveBtn();


        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(dynamicControlsPage.getDynamicElement(),"It's gone!"));
        Assert.assertEquals(dynamicControlsPage.getDynamicElement().getText(),"It's gone!");

        dynamicControlsPage.clickAddBtn();
        wait.until(ExpectedConditions.visibilityOf(dynamicControlsPage.newCheckbox()));
        Assert.assertTrue(dynamicControlsPage.newCheckbox().isDisplayed());

        dynamicControlsPage.clickEnableBtn();
        wait.until(ExpectedConditions.elementToBeClickable(dynamicControlsPage.textBox()));
        Assert.assertTrue(dynamicControlsPage.textBox().isEnabled());

        dynamicControlsPage.clickDisableBtn();
        wait.until(ExpectedConditions.attributeContains(dynamicControlsPage.textBox(),"disabled","true"));
        Assert.assertFalse(dynamicControlsPage.textBox().isEnabled());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}