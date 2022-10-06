package com.ProjectName.test;

import com.ProjectName.Base.BaseTest;
import com.ProjectName.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicControlTest extends BaseTest {



    @BeforeTest
    public void setupTest(){
        driver.get(BrowserUtils.getBaseUrl() + "/dynamic_controls");
    }

    @Test
    public void dynamicControlTest(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement removeBtn = driver.findElement(By.xpath("//button[.='Remove']"));
        removeBtn.click();
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        wait.until(ExpectedConditions.invisibilityOf(checkbox));
        WebElement messageItsGone = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(messageItsGone.isDisplayed());
        WebElement addBtn = driver.findElement(By.xpath("//button[.='Add']"));
        addBtn.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@type='checkbox']"))));
        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='checkbox']")).isDisplayed());

        WebElement enableBtn = driver.findElement(By.xpath("//button[.='Enable']"));
        enableBtn.click();
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        wait.until(ExpectedConditions.elementToBeClickable(textBox));
        Assert.assertTrue(textBox.isEnabled());
        WebElement disableBtn = driver.findElement(By.xpath("//button[.='Disable']"));
        disableBtn.click();
        wait.until(ExpectedConditions.elementSelectionStateToBe(textBox, !textBox.isEnabled()));


    }

}
