package com.hired.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPage {
    public WebDriver driver;
    public CheckBoxPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//form[@id='checkboxes']/input[1]")
    public WebElement checkBox1;

    @FindBy(xpath="//form[@id='checkboxes']/input[2]")
    public WebElement checkBox2;

}
