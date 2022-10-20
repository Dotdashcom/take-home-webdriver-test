package com.dotdash.pages;

import com.dotdash.utils.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPage {

    @FindBy(xpath = "//div[@id='hot-spot']")
    public WebElement hotSpot;

    public ContextMenuPage() {
        PageFactory.initElements(BrowserFactory.getDriver(), this);
    }
}
