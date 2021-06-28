package com.task.pages;

import com.task.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class iFramePage {


    public iFramePage(){
        PageFactory.initElements(Driver.getDriver() ,this );
    }


    @FindBy(id = "tinymce")
    public WebElement content;








}
