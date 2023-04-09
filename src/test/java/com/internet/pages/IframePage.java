package com.internet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IframePage extends BasePage{


    @FindBy(id = "tinymce")
    private WebElement textInput;

    @FindBy(id = "mce_0_ifr")
    public WebElement inFrame;
    @FindBy(css = ".tox-notification__dismiss.tox-button")
    public WebElement closeButton;



    public void clickClose(){
        waitforVisibilityandClickable(closeButton);
        closeButton.click();
    }

    public void changeToFrame(){
        driver.switchTo().frame(inFrame);
    }

    public void writeText(){
        clickClose();
        changeToFrame();
        textInput.clear();
        textInput.sendKeys("Hello World");
    }

    public String getText(){
        return textInput.getText();
    }

}
