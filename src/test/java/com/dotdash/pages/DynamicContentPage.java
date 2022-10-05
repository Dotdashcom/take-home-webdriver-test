package com.dotdash.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DynamicContentPage extends BasePage{


    @FindBy(xpath="(//div[@class='large-10 columns'])[1]")
    public WebElement firstElement;
}
