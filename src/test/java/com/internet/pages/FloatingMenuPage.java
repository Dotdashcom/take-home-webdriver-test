package com.internet.pages;

import com.internet.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FloatingMenuPage extends BasePage{


    @FindBy(xpath = "//a[@target='_blank']")
    private WebElement footer;

    @FindBy(id = "menu")
    private WebElement floatingMenu;

    public boolean ifMenuisShown(){
        return floatingMenu.isDisplayed();
    }

    public void scrollToFooter(){
        BrowserUtils.scrollTo(footer);
    }
}
