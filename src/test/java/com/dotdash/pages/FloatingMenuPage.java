package com.dotdash.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FloatingMenuPage extends BasePage{

    @FindBy (id = "menu")
    public WebElement floatingMenu;

    @FindBy (id = "page-footer")
    public WebElement endOfPage;

}
