package com.task.pages;

import com.task.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class notificationMessagePage {


    public notificationMessagePage(){
        PageFactory.initElements(Driver.getDriver() ,this );
    }


    @FindBy(linkText = "Click here")
    public WebElement clickHere;

    @FindBy(id = "flash")
    public WebElement messages;



}
