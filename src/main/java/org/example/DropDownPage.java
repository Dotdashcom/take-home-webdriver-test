package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends BasePage {

    protected WebDriver driver;
    By dropDownPage = By.cssSelector("[href='\\/dropdown']");
    By dropDownSelector = By.cssSelector("select#dropdown");


    public DropDownPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getDropDownPage(){
        return driver.findElement(dropDownPage);
    }

    public WebElement getDropDownSelector(){
        return driver.findElement(dropDownSelector);
    }


    public void selectOption1(){
        getDropDownPage().click();
        Select DropDownSelect = new Select(getDropDownSelector());
        DropDownSelect.selectByVisibleText("Option 1");
    }
    public void selectOption2(){

        getDropDownPage().click();
        Select DropDownSelect = new Select(getDropDownSelector());
        DropDownSelect.selectByVisibleText("Option 2");

    }

    public String getSelectedOption(){
        return new Select(getDropDownSelector()).getFirstSelectedOption().getText();
    }


}
