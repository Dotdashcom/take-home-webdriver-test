package com.Pages;

import com.BaseTest.TestEngine;
import com.CommonMethods.SeleniumCommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropDownRepository extends TestEngine {

    //parameterized constructor
    public DropDownRepository (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//select[@id='dropdown']")
    public WebElement _dropDownTextBox;

    @FindBy(how = How.XPATH, using = "//option[@selected='selected' and text()='Option 1']")
    public WebElement _dropDownFirstOptionSelected;

    @FindBy(how = How.XPATH, using = "//option[@selected='selected' and text()='Option 2']")
    public WebElement _dropDownSecondOptionSelected;

    public void SelectDropDownOption1(){
        SeleniumCommonMethods.SelectDropDownByVisibleText(_dropDownTextBox,"Option 1");
    }

    public void SelectDropDownOption2(){
        SeleniumCommonMethods.SelectDropDownByVisibleText(_dropDownTextBox,"Option 2");
    }

    public boolean IsOption1Displayed(){
        return _dropDownFirstOptionSelected.isDisplayed();
    }

    public boolean IsOption2Displayed(){
        return _dropDownSecondOptionSelected.isDisplayed();
    }
}
