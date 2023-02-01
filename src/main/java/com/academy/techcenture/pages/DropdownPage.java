package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class DropdownPage extends BasePage{
    public DropdownPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    @FindBy (tagName = "select")
    private WebElement dropDown;

    public void verifyDropDown(){
        Select select = new Select(dropDown);
        for (int i = 1; i < select.getOptions().size(); i++) {
            select.selectByIndex(i);
            softAssert.assertTrue(select.getOptions().get(i).isSelected(), "Option " + i + " is not selected");
        }
    }
}
