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

public class DynamicControlsPage {

    WebDriver localDriver;
    public DynamicControlsPage(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver, this);
    }

    @FindBy(css = "a[href='/dynamic_controls']")
    @CacheLookup
    WebElement linkDynamicControls;

    @FindBy(css = "input[label='blah']")
    @CacheLookup
    WebElement dynamicControlsCheckbox;

    @FindBy(css = "button[onclick='swapCheckbox()']")
    @CacheLookup
    WebElement dynamicControlsRemoveButton;

    @FindBy(css = "button[onclick='swapCheckbox()']")
    @CacheLookup
    WebElement dynamicControlsAddButton;

    @FindBy(css = "button[onclick='swapInput()']")
    @CacheLookup
    WebElement dynamicControlEnable;

    @FindBy(css = "button[onclick='swapInput()']")
    @CacheLookup
    WebElement dynamicControlDisable;

    public void clickDynamicControlLink() {
        linkDynamicControls.click();
    }

    public void enableDynamicControlCheckbox() {
        dynamicControlsCheckbox.click();
    }

    public void clickDynamicControlRemove() {
        dynamicControlsRemoveButton.click();
        WebDriverWait wait = new WebDriverWait(localDriver, 5);

        boolean isVisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
        if (isVisible) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    public void clickDynamicControlAdd() {
        dynamicControlsAddButton.click();
        WebDriverWait wait = new WebDriverWait(localDriver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
        boolean isVisible = element.isDisplayed();
        if (isVisible) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    public void clickDynamicControlEnable() {
        dynamicControlEnable.click();
            WebDriverWait wait = new WebDriverWait(localDriver, 5);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'enabled!')]")));
            boolean isVisible = element.isDisplayed();
            if (isVisible) {
                Assert.assertTrue(true);
            } else {
                Assert.fail();
            }
    }

    public void clickDynamicControlDisable() {
        dynamicControlDisable.click();
        WebDriverWait wait = new WebDriverWait(localDriver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'disabled!')]")));
        boolean isVisible = element.isDisplayed();
        if (isVisible) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

}
