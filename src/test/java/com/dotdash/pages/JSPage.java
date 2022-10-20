package com.dotdash.pages;

import com.dotdash.utils.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JSPage {
    @FindBy(xpath = "//p[contains(text(),'This page has a JavaScript error in the onload event.')]")
    public WebElement js;

    public JSPage() {
        PageFactory.initElements(BrowserFactory.getDriver(), this);
    }

    public static WebElement button(String text){
        return BrowserFactory.getDriver().findElement(By.xpath("//button[text()='"+text+"']"));
    }
}
