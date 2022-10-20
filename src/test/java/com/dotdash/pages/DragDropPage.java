package com.dotdash.pages;

import com.dotdash.utils.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragDropPage {
    @FindBy(xpath = "//div[@id='column-a']")
    public WebElement dragBox;

    @FindBy(xpath = "//div[@id='column-b']")
    public WebElement dropBox;

    @FindBy(xpath = " //div[@id='column-b']//header[text()='A']")
    public WebElement displayBox;

    public DragDropPage() {
        PageFactory.initElements(BrowserFactory.getDriver(), this);
    }
}
