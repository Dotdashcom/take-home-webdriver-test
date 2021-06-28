package com.task.pages;

import com.task.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contextMenuPage {

    public contextMenuPage(){
        PageFactory.initElements(Driver.getDriver() , this );
    }

    @FindBy(id = "hot-spot")
    public WebElement right_Click_Box;





}
