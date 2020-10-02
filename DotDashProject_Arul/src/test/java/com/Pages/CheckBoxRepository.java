package com.Pages;

import com.BaseTest.TestEngine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxRepository extends TestEngine {

    //parameterized constructor
    public CheckBoxRepository (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//input[@type='checkbox'][1]")
    public WebElement _checkBox1;

    @FindBy(how = How.XPATH, using = "//input[@type='checkbox'][2]")
    public WebElement _checkBox2;

    public void ClickCheckBox1(){
        _checkBox1.click();
    }

    public void ClickCheckBox2(){
        _checkBox2.click();
    }

    public boolean CheckBox1IsChecked(){
        return _checkBox1.isSelected();
    }

    public boolean CheckBox2IsChecked(){
        return _checkBox2.isSelected();
    }
}