package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Set;

public class OpenNewTabPage extends BasePage {

    @FindBy(xpath = "//a[@href='/windows']")
    WebElement link;

    @FindBy(xpath = "//a[@href='/windows/new']")
    WebElement button;

    @FindBy(xpath = "//div[@class='example']/h3")
    WebElement text;


    public void clickOnLink() {
        link.click();
    }

    public void openNewTab() {
        button.click();
        String mainPage = driver.getWindowHandle();

        Set<String> allOpenWindows = driver.getWindowHandles();
        for (String windowHandle : allOpenWindows) {
            if (!windowHandle.equals(mainPage)) {
                driver.switchTo().window(windowHandle);
            }
        }
        Assert.assertTrue(text.isDisplayed());
    }
}
