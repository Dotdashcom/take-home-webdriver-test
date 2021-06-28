package com.task.pages;

import com.task.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkBoxPage {

    public checkBoxPage(){
        PageFactory.initElements(Driver.getDriver() , this );
    }


    @FindBy ( xpath = "//form[@id='checkboxes']/input[1]" )
    public WebElement checkBox1;

    @FindBy ( xpath = "//form[@id='checkboxes']/input[2]" )
    public WebElement checkBox2;





}
