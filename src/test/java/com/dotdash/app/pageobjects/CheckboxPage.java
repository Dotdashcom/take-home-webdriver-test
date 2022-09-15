package com.dotdash.app.pageobjects;

import com.dotdash.core.helpers.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CheckboxPage extends BasePage {
    @FindBy(css="input[type=\"checkbox\"]")
    List<WebElement> checkboxList;

    public CheckboxPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckbox1(){
        checkboxList.get(0).click();
    }

    public void clickCheckbox2(){
        checkboxList.get(1).click();
    }

    public boolean isCheckbox1Selected(){return checkboxList.get(0).isSelected();}
    public boolean isCheckbox2Selected(){return checkboxList.get(1).isSelected();}

}
