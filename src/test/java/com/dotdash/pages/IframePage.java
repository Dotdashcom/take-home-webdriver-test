package com.dotdash.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IframePage extends BasePage{

    @FindBy (id = "mce_0_ifr")
    public WebElement iframe;

    @FindBy (id = "tinymce")
    public WebElement textBox;

}
