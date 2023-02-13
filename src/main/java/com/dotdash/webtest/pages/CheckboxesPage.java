package com.dotdash.webtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxesPage extends WebPage {

    @FindBy(css = "#content > ul > li:nth-child(6) > a")
    protected WebElement checkboxesButton;

    @FindBy(css = "#checkboxes > input:first-child")
    protected WebElement checkbox1;

    @FindBy(css = "#checkboxes > input:nth-child(3)")
    protected WebElement checkbox2;

    public CheckboxesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void goToCheckboxPage() {
        checkboxesButton.click();
    }

    public void clickCheckbox1() {
        checkbox1.click();
    }

    public boolean isCheckbox1Selected() {
        return checkbox1.isSelected();
    }

    public void clickCheckbox2() {
        checkbox2.click();
    }

    public boolean isCheckbox2Selected() {
        return checkbox2.isSelected();
    }
}
