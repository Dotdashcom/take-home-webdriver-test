package com.automation.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ContextMenuPage extends BasePage{

    @FindBy(xpath = "//a[@href='/context_menu']")
    WebElement contextMenuLink;

    @FindBy(id = "hot-spot")
    WebElement contextMenu;


    public void clickOnContextLink(){
        contextMenuLink.click();
    }

    public void rightClick(){
        Actions actions = new Actions(driver);
        actions.contextClick(contextMenu).perform();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals("You selected a context menu", alertText);
        alert.accept();
    }
}
