package com.new_york_remote.pages;

import com.new_york_remote.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPage {
    public ContextMenuPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="hot-spot")
    public WebElement contextBox;
@FindBy(xpath = "(//script)[7]")
    public WebElement alertMessage;
}
