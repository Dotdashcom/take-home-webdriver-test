package com.ProjectName.test;

import com.ProjectName.Base.BaseTest;
import com.ProjectName.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicLoadingTest extends BaseTest {

    @BeforeTest
    public void setupTest(){
        driver.get(BrowserUtils.getBaseUrl() + "/dynamic_loading/2");
    }

    @Test
    public void dynamicLoadingTest(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement startBtn = driver.findElement(By.xpath("//button"));
        startBtn.click();
        WebElement helloWorld = driver.findElement(By.xpath("//div[@id='finish']"));
        wait.until(ExpectedConditions.visibilityOf(helloWorld));
        Assert.assertTrue(helloWorld.isDisplayed());
    }
}
