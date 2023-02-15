package com.dotdash.webtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends WebPage {

    @FindBy(css = "#content > ul > li:nth-child(11) > a")
    protected WebElement dropDownButton;

    @FindBy(id = "dropdown")
    protected WebElement dropDownList;

    protected Select select;

    public DropdownPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void goToDropDownPage() {
        dropDownButton.click();
    }

    public void chooseOption1() {
        select = new Select(dropDownList);
        select.selectByValue("1");
    }

    public String getOptionText() {
        select = new Select(dropDownList);
        return select.getFirstSelectedOption().getText();
    }

    public void chooseOption2() {
        select = new Select(dropDownList);
        select.selectByVisibleText("Option 2");
    }
}
