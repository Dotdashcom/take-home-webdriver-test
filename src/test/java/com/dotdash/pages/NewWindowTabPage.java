package com.dotdash.pages;


import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewWindowTabPage extends BasePage{

    public NewWindowTabPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Click Here")
    public WebElement clickHere;


}
