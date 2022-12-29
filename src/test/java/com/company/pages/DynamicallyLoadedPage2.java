package com.company.pages;

import com.company.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicallyLoadedPage2 {

    public DynamicallyLoadedPage2(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath="//*[@id='start']/button")
    public WebElement StartButton;

    @FindBy (xpath = "//*[@id='finish']/h4")
    public WebElement HelloWorld;
}
