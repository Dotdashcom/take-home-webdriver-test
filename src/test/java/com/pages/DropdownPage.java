package com.pages;

import com.testbase.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DropdownPage extends BaseClass {

    public DropdownPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.ID, using =  "dropdown")
    public WebElement _dropdownBoxID;



}
