package com.DotDash.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicContentPage {
    public WebDriver ldriver;
    @FindBy(id = "content")
    WebElement txtcontent;

    public DynamicContentPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    public String gettxtcontent() {
        return txtcontent.getText();
    }


}
