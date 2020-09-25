package com.theInternet.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class checkBoxPage extends basePage {

    @FindBy(xpath = "//*[.='Checkboxes']")
    public WebElement headerMsg;

    @FindBy(tagName = "input")
    public List<WebElement> checkboxes;
}
