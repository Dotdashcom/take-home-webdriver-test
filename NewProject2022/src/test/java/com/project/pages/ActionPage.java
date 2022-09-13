package com.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.project.utility.Driver.getDriver;

public class ActionPage {

    public ActionPage(){
        PageFactory.initElements(getDriver(),this);}

    @FindBy(xpath = "//a[.='Click here']")
    public WebElement clickButton;

    @FindBy(xpath = "//div[@class='flash notice']")
    public WebElement Message;


}
