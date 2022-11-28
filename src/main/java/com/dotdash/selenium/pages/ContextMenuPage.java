package com.dotdash.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends BasePage {
    @FindBy(id="hot-spot")
    WebElement dottedBox;

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    public void rightClickDottedBox(){
        Actions action = new Actions(driver);
        action.contextClick(dottedBox).build().perform();
    }

    public String getAlertMessage(){
        return driver.switchTo().alert().getText();
    }
}
