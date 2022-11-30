package com.dotdash.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {

    @FindBy(how = How.CSS, using = "#dropdown")
    private WebElement dropdown;


    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public DropdownPage goToDropdownPage() {
        driver.get(BASEURL + "/dropdown");
        return this;
    }

    public DropdownPage selectOption(String value) {
        selectFromDropdown(dropdown).selectByValue(value);
        return this;
    }

    public String getSelectedOption() {
        return selectFromDropdown(dropdown).getFirstSelectedOption().getText();
    }
}
