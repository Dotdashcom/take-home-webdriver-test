package com.rural.rural.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

// page_url = http://localhost:7080/dropdown
public class DropDownPage {


    @FindBy(xpath = "//*[@id='dropdown']")
    public WebElement selectDropdown;


    public DropDownPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
