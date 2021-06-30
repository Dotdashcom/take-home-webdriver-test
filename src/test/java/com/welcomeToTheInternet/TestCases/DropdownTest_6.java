package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.DropdownPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest_6 extends BaseClass{

    @Test
    public void DropdownTest() {
        driver.get(baseURL);
        DropdownPage dropdown = new DropdownPage(driver);

        dropdown.clickDropdownLink();
        logger.info("Navigate to the Dropdown menu page");
        dropdown.clickDropDownList();
        logger.info("Dropdown menu has been clicked");
        dropdown.waitForList(driver);
        dropdown.selectElement1();
        logger.info("Element1 was selected");
        boolean isSelected1 = driver.findElement(By.cssSelector("option[value='1'][selected='selected']")).isSelected();
        if (isSelected1) {
            Assert.assertTrue(true);
            logger.info("Test passed");
        } else {
            Assert.assertFalse(false);
            logger.info("Test failed");
        }

        dropdown.clickDropDownList();
        logger.info("Dropdown menu has been clicked");
        dropdown.waitForList(driver);
        dropdown.selectElement2();
        logger.info("Element2 was selected");
        boolean isSelected2 = driver.findElement(By.cssSelector("option[value='2'][selected='selected']")).isSelected();
        if (isSelected2) {
            Assert.assertTrue(true);
            logger.info("Test passed");
        } else {
            Assert.assertFalse(false);
            logger.info("Test failed");
        }

    }
}
