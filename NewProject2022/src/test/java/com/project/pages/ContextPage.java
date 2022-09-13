package com.project.pages;

import com.project.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextPage {

    public ContextPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="hot-spot")
    public WebElement Context;




}
