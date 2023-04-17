package com.rural.rural.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = http://localhost:7080/checkboxes
public class CheckBoxesPage {
    @FindBy(xpath = "/html/body/div[2]/div/div/form/input[1]")
    public WebElement input;

    @FindBy(xpath = "/html/body/div[2]/div/div/form/input[2]")
    public WebElement input2;




    





    public CheckBoxesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
