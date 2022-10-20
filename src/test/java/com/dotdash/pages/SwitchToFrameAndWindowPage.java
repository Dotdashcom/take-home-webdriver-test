package com.dotdash.pages;

import com.dotdash.utils.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwitchToFrameAndWindowPage {

    @FindBy(xpath = "//a[text()='Click Here']")
    public WebElement clickHere;

    @FindBy(xpath = "//div[@aria-label='Close']")
    public WebElement close;

    @FindBy(xpath = "//iframe[@id='mce_0_ifr']")
    public WebElement iframe;

    @FindBy(xpath = "//body")
    public WebElement iframeBody;

    @FindBy(xpath = "//h3[text()='New Window']")
    public WebElement newWindowValidate;


    public SwitchToFrameAndWindowPage() {
        PageFactory.initElements(BrowserFactory.getDriver(), this);
    }
}
