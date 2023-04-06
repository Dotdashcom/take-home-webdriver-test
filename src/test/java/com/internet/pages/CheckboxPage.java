package com.internet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckboxPage extends BasePage {


    @FindBy(css = "input:nth-of-type(1)")
    private WebElement checkbox1;

    @FindBy(css = "input:nth-of-type(2)")
    private WebElement checkbox2;

    public void clickCheckbox1(){
        waitforVisibilityandClickable(checkbox1);
        checkbox1.click();
    }
    public void clickCheckbox2(){
        waitforVisibilityandClickable(checkbox2);
        checkbox2.click();
    }

    public boolean ifCheckboxSelected(int checkboxNumber){
        if (checkboxNumber==1)
            return checkbox1.isSelected();
        else if (checkboxNumber==2) {
            return checkbox2.isSelected();
        }
        else
            return false;
    }



}
