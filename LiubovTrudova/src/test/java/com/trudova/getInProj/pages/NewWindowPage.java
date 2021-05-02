package com.trudova.getInProj.pages;

import com.trudova.getInProj.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewWindowPage extends BasePage{
    public NewWindowPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText = "Click Here")
    public WebElement clickHereLink;
}
