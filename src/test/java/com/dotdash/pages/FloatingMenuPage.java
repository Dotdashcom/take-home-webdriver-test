package com.dotdash.pages;

import com.dotdash.utils.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FloatingMenuPage {
    @FindBy(xpath = "//div[@id='menu']")
    public WebElement floatingMenu;

    @FindBy(xpath = "//p[3]")
    public WebElement scroll;

    public FloatingMenuPage() {
        PageFactory.initElements(BrowserFactory.getDriver(), this);
    }
}
