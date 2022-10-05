package com.dotdash.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class IframePage extends BasePage {


    @FindBy(linkText = "iFrame")
    public WebElement iframeLink;

    @FindBy(css = "#mce_0_ifr")
    public WebElement iframe;

    @FindBy(css = "#tinymce")
    public WebElement getIframeBody;

}
