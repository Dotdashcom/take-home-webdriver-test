package com.interview.pages;

import com.interview.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FloatingMenuPage {
    public FloatingMenuPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

  @FindBy(xpath = "//h3")
    public WebElement floatingMenu;


}
