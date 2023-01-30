package com.ddm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends WebPage {

    @FindBy(id = "hot-spot")
    WebElement box;

    public ContextMenuPage(WebDriver remoteDriver) {
        super(remoteDriver);
    }

    public void contextClickOnTarget() {
        mouseAndKeyBoardActions.contextClick(box).build().perform();
    }

    public String getAlertText() {
        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        return alertText;
    }
}
