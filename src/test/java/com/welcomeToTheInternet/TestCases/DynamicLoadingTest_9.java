package com.welcomeToTheInternet.TestCases;

import com.welcomeToTheInternet.PageObjects.DynamicLoadingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DynamicLoadingTest_9 extends BaseClass{

    @Test
    public void DynamicLoadedElementsTest() throws IOException {
        driver.get(baseURL);
        DynamicLoadingPage dynamicLoaded = new DynamicLoadingPage(driver);

        dynamicLoaded.clickDynamicLoadingLink();
        dynamicLoaded.clickLinkElementHidden();
        dynamicLoaded.clickHiddenButton();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Hello World!')]")));
        boolean isVisible = element1.isDisplayed();
        if (isVisible) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
        driver.navigate().back();

        dynamicLoaded.clickLinkElementRendered();
        dynamicLoaded.clickRenderedButton();
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        WebElement element2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Hello World!')]")));
        boolean isVisible2 = element2.isDisplayed();
        if (isVisible2) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }

    }
}
