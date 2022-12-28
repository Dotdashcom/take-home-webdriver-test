package com.test.localhost.pages;

import com.test.localhost.utils.BrowserUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IframePage {

    public IframePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[.='Frames']")
    WebElement frameButton;
    @FindBy(xpath = "//a[.='iFrame']")
    WebElement iFrameButton;

    @FindBy(xpath = "//div[@class='tox-icon']")
    WebElement xButton;
    @FindBy(tagName = "p")
    WebElement messageInBox;

    public void clickButtons(){
        frameButton.click();
        iFrameButton.click();

    }
    public void notificationMsg(WebDriver driver){
        driver.switchTo().defaultContent();
        xButton.click();

    }

    public String sendAndGetText(WebDriver driver){
        driver.switchTo().frame("mce_0_ifr");
        messageInBox.clear();
        messageInBox.sendKeys("my input message");
        return messageInBox.getText();

    }

}
