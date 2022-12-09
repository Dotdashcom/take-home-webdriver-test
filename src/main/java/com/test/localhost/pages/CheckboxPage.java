package com.test.localhost.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckboxPage {

    public CheckboxPage(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
    @FindBy(linkText = "Checkboxes")
    WebElement checkboxButton;

    @FindBy(xpath = "//*[@id=\"checkboxes\"]/input[1]")
    WebElement checkbox1;

    @FindBy(xpath = "//*[@id=\"checkboxes\"]/input[2]")
    WebElement checkbox2;

    public void clickCheckboxButton(){
        checkboxButton.click();
    }
    public void clickCheckbox1(){
        checkbox1.click();
    }
    public boolean validateCheckbox1Selected(){
        return checkbox1.isSelected();
    }
    public void clickCheckbox2(){
        checkbox2.click();
    }
    public boolean validateCheckbox2Selected(){
        return checkbox2.isSelected();
    }


}
