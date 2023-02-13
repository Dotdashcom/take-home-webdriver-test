package com.dotdash.webtest.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPage extends WebPage {

    @FindBy(css = "#content > ul > li:nth-child(7) > a")
    protected WebElement contextMenuButton;

    @FindBy(id = "hot-spot")
    protected WebElement rightClickBox;

    public ContextMenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToContextMenuPage() {
        contextMenuButton.click();
    }

    public void rightClickTest() {
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickBox).perform();
    }

    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }
}
