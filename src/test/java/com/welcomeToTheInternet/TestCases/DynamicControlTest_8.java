package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.DynamicControlsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlTest_8 extends BaseClass{

    @Test
    public void DynamicControlTest() {
        driver.get(baseURL);
        DynamicControlsPage dynamicControl = new DynamicControlsPage(driver);
        dynamicControl.clickDynamicControlLink();
        dynamicControl.enableDynamicControlCheckbox();

        dynamicControl.clickDynamicControlRemove();
        WebDriverWait wait1 = new WebDriverWait(driver, 5);
        boolean isVisible1 = wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
        if (isVisible1) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }

        dynamicControl.clickDynamicControlAdd();
        WebDriverWait wait2 = new WebDriverWait(driver, 5);
        WebElement element2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
        boolean isVisible2 = element2.isDisplayed();
        if (isVisible2) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }


        dynamicControl.clickDynamicControlEnable();
        WebDriverWait wait3 = new WebDriverWait(driver, 5);
        WebElement element3 = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'enabled!')]")));
        boolean isVisible3 = element3.isDisplayed();
        if (isVisible3) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }


        dynamicControl.clickDynamicControlDisable();
        WebDriverWait wait4 = new WebDriverWait(driver, 5);
        WebElement element4 = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'disabled!')]")));
        boolean isVisible4 = element4.isDisplayed();
        if (isVisible4) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }
}
