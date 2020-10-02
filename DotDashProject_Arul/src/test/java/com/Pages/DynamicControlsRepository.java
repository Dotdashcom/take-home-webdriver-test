package com.Pages;

import com.BaseTest.TestEngine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsRepository extends TestEngine {

    //parameterized constructor
    public DynamicControlsRepository(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//button[text()='Remove']")
    public WebElement _removeButton;

    @FindBy(how = How.XPATH, using = "//button[text()='Add']")
    public WebElement _addButton;

    @FindBy(how = How.XPATH, using = "//input[@type='checkbox']")
    public WebElement _checkBoxLocator;

    @FindBy(how = How.XPATH, using = "//button[text()='Enable']")
    public WebElement _enableButton;

    @FindBy(how = How.XPATH, using = "//button[text()='Disable']")
    public WebElement _disableButton;

    @FindBy(how = How.XPATH, using = "//form[@id='input-example']//p")
    public WebElement _message;

    public void ClickRemoveBtn(){
        _removeButton.click();
    }

    public void ClickAddBtn(){
        _addButton.click();
    }

    public boolean IsCheckBoxDisplayed(){
        return _checkBoxLocator.isDisplayed();
    }

    public boolean IsAddDisplayed(){
        return _addButton.isDisplayed();
    }

    public void ClickEnableBtn(){
        _enableButton.click();
    }

    public void ClickDisableBtn(){
        _disableButton.click();
    }
}