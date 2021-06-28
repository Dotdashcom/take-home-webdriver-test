package com.task.pages;

import com.task.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class dynamicLoadingPage {

    public dynamicLoadingPage(){
        PageFactory.initElements(Driver.getDriver() ,this );
    }


    @FindBy(xpath = "//div[@id='start']/button")
    public WebElement startButton;

    @FindBy(xpath = "//div[@id='loading']/img")
    public WebElement loading;

    @FindBy(xpath = "//div[@id='finish']/h4")
    public WebElement helloWorldText;




}
