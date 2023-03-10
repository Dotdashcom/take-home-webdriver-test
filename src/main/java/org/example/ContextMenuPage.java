package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage extends BasePage {

    protected WebDriver driver;

    By contextMenu = By.cssSelector("[href='\\/context_menu']");

    By contextMenuBox = By.cssSelector("div#hot-spot");

    public ContextMenuPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getContextMenu(){
        return driver.findElement(contextMenu);
    }

    public WebElement getContextMenuBox(){
        return driver.findElement(contextMenuBox);
    }

    public void rightClickOnContextMenuBox(){
        getContextMenu().click();
        Actions rightclick = new Actions(driver);
        rightclick.contextClick(getContextMenuBox()).perform();
    }
    public String alertMenuText(){
        String alerttext = driver.switchTo().alert().getText();
        return alerttext;
    }

}
