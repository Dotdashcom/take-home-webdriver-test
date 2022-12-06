package com.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.base.TestBase;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownPage extends TestBase{

    @FindBy(xpath="//*[@id='dropdown']")
    WebElement dropdownlist;

    @FindBy(xpath="//*[@id='dropdown']/option[2]")
    WebElement dropdown1;

    @FindBy(xpath="//*[@id='dropdown']/option[3]")
    WebElement dropdown2;


    public DropdownPage(){
        PageFactory.initElements(driver, this);
    }


    public WebElement dropdownMenu(){
        return dropdownlist;
    }

    public String getOption1(){
        return dropdown1.getText() ;
    }

    public String getOption2(){
        return dropdown2.getText() ;
    }

}
