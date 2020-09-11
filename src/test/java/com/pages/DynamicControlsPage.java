package com.pages;

import com.testbase.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPage extends BaseClass {

    public DynamicControlsPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }



    @FindBy(how = How.ID, using =  "checkbox")
    public WebElement _checkbox;

    @FindBy(how = How.XPATH, using =  "//button[text()='Remove']")
    public WebElement _removeButton;

    @FindBy(how = How.XPATH, using =  "//button[text()='Add']")
    public WebElement _addButton;

    @FindBy(how = How.XPATH, using =  "//button[text()='Enable']")
    public WebElement _enableButton;

    @FindBy(how = How.XPATH, using =  "//button[text()='Disable']")
    public WebElement _disableButton;

    @FindBy(how = How.XPATH, using =  "//input[@type='text']")
    public WebElement _textBox;



    public void ClickRemoveButton(){
        _removeButton.click();
    }
    public void ClickAddButton(){
        _addButton.click();
    }
    public void ClickEnableButton(){
        _enableButton.click();
    }
    public void ClickDisableButton(){
        _disableButton.click();
    }
}
