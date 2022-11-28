package com.dotdash.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends BasePage {
    @FindBy(id="dropdown")
    WebElement dropdown;

    public DropDownPage(WebDriver driver) {
        super(driver);
    }

    public void selectDropdownOptionByText(String text){
        Select dd = new Select(dropdown);
        dd.selectByVisibleText(text);
    }

    public String getSelectedDropdownOption(){
        Select dd = new Select(dropdown);
        return dd.getFirstSelectedOption().getText();
    }
}
