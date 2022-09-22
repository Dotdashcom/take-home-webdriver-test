package com.dotdash.pages;


import com.dotdash.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IframePage extends BasePage{

    public IframePage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "iFrame")
    public WebElement iframeLink;

    @FindBy(css = "#mce_0_ifr")
    public WebElement iframe;

    @FindBy(css = "#tinymce")
    public WebElement getIframeBody;

}
