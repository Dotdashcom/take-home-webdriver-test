package com.ddm.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class MultipleWindowsPage extends WebPage {

    @FindBy(css = "div.example > a")
    protected WebElement newWindowLink;

    protected String firstWindowID;
    protected String secondWindowID;

    public MultipleWindowsPage(WebDriver remoteDriver) {
        super(remoteDriver);
    }

    public void openANewWindow() {
        firstWindowID = driver.getWindowHandle();
        newWindowLink.click();
        Set<String> allIDs = driver.getWindowHandles();
        for(String id: allIDs) {
            if(!id.equals(firstWindowID)) {
                secondWindowID = id;
                break;
            }
        }
    }

    public void switchToChildWindow() {
        driver.switchTo().window(secondWindowID);
    }

    public void switchToParenWindow() {
        driver.switchTo().window(firstWindowID);
    }

    public String getTextInNewWindow() {
        return driver.findElement(By.cssSelector("div.example > h3")).getText();
    }

    public void closeChildWindow() {
        if(!secondWindowID.isEmpty()) {
            driver.close();
        }
    }
}