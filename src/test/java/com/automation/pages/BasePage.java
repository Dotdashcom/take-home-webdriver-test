package com.automation.pages;

import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//li/a")
    private List<WebElement> options;

    public WebElement getOption(String text){
        for(WebElement e: options){
            if(e.getText().equals(text)) return e;
        }
        throw new RuntimeException("No such option!");
    }
}
