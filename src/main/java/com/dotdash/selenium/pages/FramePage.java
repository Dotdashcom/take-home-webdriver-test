package com.dotdash.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramePage extends BasePage {
    @FindBy(css="a[href*=\"iframe\"]")
    WebElement iframeLink;

    @FindBy(id="mce_0_ifr")
    WebElement iframe;

    @FindBy(css="[id=\"tinymce\"] p")
    WebElement editor;

    public FramePage(WebDriver driver) {
        super(driver);
    }

    public void clickIframeLink(){
        iframeLink.click();
    }

    public void switchToIframe(){
        driver.switchTo().frame(iframe);
    }

    public void typeInEditor(String text){
        switchToIframe();
        editor.clear();
        editor.sendKeys(text);
    }

    public String getEditorText(){
        return editor.getText();
    }
}
