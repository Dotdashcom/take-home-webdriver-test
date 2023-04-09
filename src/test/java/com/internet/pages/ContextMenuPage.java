package com.internet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends BasePage{

    @FindBy(id = "hot-spot")
    private WebElement contextMenu;



    public void rightClickContext(){
        waitforVisibilityandClickable(contextMenu);
        action.contextClick(contextMenu).perform();
    }




}
