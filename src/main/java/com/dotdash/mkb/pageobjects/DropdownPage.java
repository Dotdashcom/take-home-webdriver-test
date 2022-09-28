package com.dotdash.mkb.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class DropdownPage extends BasePage {

    @FindBy(id = "dropdown")
    private WebElement ddlDropdownList;

    public DropdownPage(WebDriver webdriver) {
        super(webdriver);
    }

    public void select(String option) {
        Select select = new Select(ddlDropdownList);
        List<WebElement> allOptions = select.getOptions();

        for (WebElement temp: allOptions) {
            if (temp.getText().equals(option)) {
                temp.click();
                break;
            }
        }
    }

    public String getSelectedOption() {
        Select select = new Select(ddlDropdownList);

        return select.getFirstSelectedOption().getText();
    }
}