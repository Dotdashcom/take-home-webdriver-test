package com.DotDash.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxPage {
    public WebDriver ldriver;

    public CheckboxPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(xpath = "//form[@id='checkboxes']/input[1]")
    public WebElement chkbox1;

    @FindBy(xpath = "//form[@id='checkboxes']/input[2]")
    public WebElement chkbox2;



    public void clkchkbox1()
    {
        chkbox1.click();
    }

    public void clkchkbox2()
    {
        chkbox2.click();
    }

}