package com.web.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.web.base.TestBase;


public class CheckBoxesPage extends TestBase{

    @FindBy(xpath="(//form[@id='checkboxes']/input[@type='checkbox'])[1]")
    WebElement checkBox1;

    @FindBy(xpath="(//form[@id='checkboxes']/input[@type='checkbox'])[2]")
    WebElement checkBox2;

    public CheckBoxesPage(){
        PageFactory.initElements(driver, this);
    }

    public boolean checkBox1Selected(){
        return checkBox1.isSelected();
    }
    public boolean checkBox2Selected(){
        return checkBox2.isSelected();
    }


    public void checkboxSelected(){
        checkBox1.click();
        checkBox2.click();
    }
}
