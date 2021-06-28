package com.task.pages;

import com.task.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dragAndDropPage {

    public dragAndDropPage(){
        PageFactory.initElements(Driver.getDriver() , this );
    }

    @FindBy(xpath = "//div[@id='column-a']" )
    public WebElement fromColumnA;

    @FindBy(xpath = "//div[@id='column-b']" )
    public WebElement toColumnB;








}
