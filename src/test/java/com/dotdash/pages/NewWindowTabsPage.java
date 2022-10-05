package com.dotdash.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewWindowTabsPage extends BasePage {



    @FindBy(linkText = "Click Here")
    public WebElement clickHere;
}
