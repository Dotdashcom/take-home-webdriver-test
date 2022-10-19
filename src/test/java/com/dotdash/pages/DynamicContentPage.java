package com.dotdash.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicContentPage extends BasePage{

    @FindBy(id = "content")
    public WebElement content;

}
