package com.pages;

import com.testbase.BaseClass;
import com.utils.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckboxPage extends BaseClass {

    public CheckboxPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH, using = "//input[@type='checkbox'][1]")
    public WebElement _checkBox1;

    @FindBy(how = How.XPATH, using = "//input[@type='checkbox'][2]")
    public WebElement _checkBox2;

    public void ClickCheckbox1(){
        _checkBox1.click();
    }

    public void ClickCheckbox2(){
        _checkBox2.click();
    }

    public void WaitTillvisiblityofCheckbox(){

        CommonMethods.WaitTillElementIsVisible(_checkBox1);
    }

}
