package com.dotdash.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FloatingMenuPage extends BasePage {


    @FindBy(xpath = "//div[contains(@class,'scroll large-10')]")
    public WebElement floatingMenu;

}
