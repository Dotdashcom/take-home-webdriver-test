package com.test.localhost.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {

    public DropdownPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Dropdown")
    WebElement dropDownButton;
    @FindBy(id = "dropdown")
    WebElement box;
    public void dropDownClick(){
        dropDownButton.click();
    }
    public void chooseOption1() {
        Select select = new Select(box);
        select.selectByValue("1");

    }

    public String getTextOption() {
        Select select = new Select(box);
        return select.getFirstSelectedOption().getText();

    }
    public void chooseOption2() {
        Select select = new Select(box);
        select.selectByVisibleText("Option 2");



    }
    }
