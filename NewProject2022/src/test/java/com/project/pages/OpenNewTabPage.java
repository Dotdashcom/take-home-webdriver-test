package com.project.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.project.utility.Driver.getDriver;

public class OpenNewTabPage {

    public OpenNewTabPage(){
        PageFactory.initElements(getDriver(),this);}

    @FindBy(xpath = "//a[.='Click Here']")
    public WebElement clickButton;

    @FindBy(tagName = "h3")
    public WebElement NewWindowText;






}
