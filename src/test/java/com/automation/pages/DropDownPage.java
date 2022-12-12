package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class DropDownPage extends BasePage{

    @FindBy(xpath = "//a[@href='/dropdown']")
    WebElement dropDownLink;

    @FindBy(xpath = "//select[@id='dropdown']")
    WebElement selectElement;

    public void clickOnLink(){
        dropDownLink.click();
    }
    public void dropDown(){
        Select dropdown = new Select(selectElement);

        List<WebElement> selectedOptions = dropdown.getAllSelectedOptions();
        Assert.assertTrue(selectedOptions.size() == 1
                && selectedOptions.get(0).getText().equals("Please select an option"));

        dropdown.selectByVisibleText("Option 1");
        selectedOptions = dropdown.getAllSelectedOptions();
        Assert.assertTrue(selectedOptions.size() == 1 &&
                selectedOptions.get(0).getText().equals("Option 1"));


        dropdown.selectByVisibleText("Option 2");
        selectedOptions = dropdown.getAllSelectedOptions();
        Assert.assertTrue(selectedOptions.size() == 1 &&
                selectedOptions.get(0).getText().equals("Option 2"));
    }
}
