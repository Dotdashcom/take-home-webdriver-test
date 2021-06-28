package com.welcomeToTheInternet.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DropdownPage {

    WebDriver localDriver;
    public DropdownPage (WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver, this);
    }

    @FindBy(css = "a[href='/dropdown']")
    @CacheLookup
    WebElement linkDropdown;

    @FindBy(id = "dropdown")
    @CacheLookup
    WebElement dropdownList;

    @FindBy(css = "option[value='1']")
    @CacheLookup
    WebElement element1;

    @FindBy(css = "option[value='2']")
    @CacheLookup
    WebElement element2;

    public void clickDropdownLink() {
        linkDropdown.click();
    }

    public void clickDropDownList() {
        dropdownList.click();
    }

    public void selectElement1() {
        element1.click();
        boolean isSelected = localDriver.findElement(By.cssSelector("option[value='1'][selected='selected']")).isSelected();
        if (isSelected) {
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(false);
        }
    }

    public void selectElement2() {
        element2.click();
        boolean isSelected = localDriver.findElement(By.cssSelector("option[value='2'][selected='selected']")).isSelected();
        if (isSelected) {
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(false);
        }
    }

    public void waitForList(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdown")));
    }
}
