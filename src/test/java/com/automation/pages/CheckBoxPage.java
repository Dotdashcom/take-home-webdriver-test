package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckBoxPage extends BasePage{

    @FindBy(tagName = "input")
    public List<WebElement> checkboxes;

    public WebElement getCheckBox(String cb){
        return cb.contains("1")? checkboxes.get(0): checkboxes.get(1);
    }
}
