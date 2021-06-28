package com.task.pages;

import com.task.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class openInNewTabPage {


    public openInNewTabPage(){
        PageFactory.initElements(Driver.getDriver() ,this );
    }


    @FindBy(linkText = "Click Here")
    public WebElement clickHere;




}
