package com.test.localhost.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

public class ContextMenuPage {

    public ContextMenuPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Context Menu")
    WebElement clickContextMenu;

    @FindBy(id = "hot-spot")
    WebElement rightClickBox;


    public void clickContextMenu(){
        clickContextMenu.click();

    }
    public void rightClickTest(WebDriver driver){
        Actions actions=new Actions(driver);
        actions.contextClick(rightClickBox).perform();
    }
    public String validateText(WebDriver driver){
        Alert alert=driver.switchTo().alert();
        return alert.getText();
    }

}
