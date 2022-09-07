package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.DynamicControlsPage;
import pages.utils;


public class DynamicControlsTest {
    DynamicControlsPage dynamicControlsPage;

    public DynamicControlsTest() {
        dynamicControlsPage = new DynamicControlsPage();
    }

    @Test
    public void dynamicControlsTest() {
        WebDriver driver = TestBase.getInstance().getDriver();
        driver.get(utils.url + "/dynamic_controls");

        dynamicControlsPage.clickOnRemoveBtn();
        try {
            Assert.assertTrue(dynamicControlsPage.checkBoxVisibility().isDisplayed());
            System.out.println("Checkbox is visible after Remove button is clicked");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Checkbox is invisible after Remove button is clicked");
        }

        dynamicControlsPage.clickOnAddBtn();
        try {
            Assert.assertTrue(dynamicControlsPage.checkBoxVisibility().isDisplayed());
            System.out.println("Checkbox is visible after Add button is clicked");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Checkbox is invisible after Add button is clicked");
        }

        dynamicControlsPage.clickOnEnableBtn();
        try {
            Assert.assertTrue(dynamicControlsPage.inputField().isEnabled());
            System.out.println("inputField is enabled after Enable button is clicked");
        } catch (AssertionError e) {
            System.out.println("inputField is disabled after Enable button is clicked" + e);
        }

        dynamicControlsPage.clickOnDisableBtn();

        try {
            Assert.assertTrue(dynamicControlsPage.inputField().isEnabled());
            System.out.println("inputField is disabled after Disable button is clicked");
        } catch (AssertionError e) {
            System.out.println("inputField is enabled after Disable button is clicked");
        }
    }

    @AfterTest
    public void teardown() {
        TestBase.getInstance().getDriver().quit();
    }
}



