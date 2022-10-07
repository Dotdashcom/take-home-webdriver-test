package com.hawkeye.pages;

import com.hawkeye.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FloatingMenuPage {

    @FindBy(tagName = "h3")
    public WebElement floatingMenu;

    public FloatingMenuPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



}
