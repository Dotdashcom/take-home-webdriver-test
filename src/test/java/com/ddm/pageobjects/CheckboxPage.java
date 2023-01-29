package com.ddm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckboxPage extends WebPage{

    @FindBy(css = "#checkboxes > input:first-child")
    WebElement checkbox1;

    @FindBy(css = "#checkboxes > input:nth-child(3)")
    WebElement checkbox2;

    public CheckboxPage(WebDriver remoteDriver) {
        super(remoteDriver);
    }

    public void clickCheckbox1() {
        checkbox1.click();
    }

    public boolean isCheckBox1Selected() {
        return checkbox1.isSelected();
    }

    public void clickCheckbox2() {
        checkbox2.click();
    }

    public boolean isCheckBox2Selected() {
        return checkbox2.isSelected();
    }
}
