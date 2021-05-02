package com.trudova.getInProj.pages;

import com.trudova.getInProj.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPage extends BasePage{
    public ContextMenuPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "hot-spot")
    public WebElement hotspot;
}
