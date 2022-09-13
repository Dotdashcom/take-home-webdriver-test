package com.project.pages;

import com.project.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FloatPages {

    public FloatPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(tagName = "h3")
    public WebElement floatingMenu;




}
