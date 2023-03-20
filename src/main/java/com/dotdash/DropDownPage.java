package com.dotdash;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends Util {

    protected WebDriver driver;
    // selectors
 	private By dropDownPage = By.linkText("Dropdown");
	private By dropDownSelector = By.id("dropdown");


    public DropDownPage(WebDriver driver){
        this.driver = driver;
    }

    public void openDropDownPage(){
    	driver.findElement(dropDownPage).click();;
    }

    public WebElement getDropDownSelector(){
        return driver.findElement(dropDownSelector);
    }


    public void selectOption1(){
    	openDropDownPage();
        Select DropDownSelect = new Select(getDropDownSelector());
        DropDownSelect.selectByVisibleText("Option 1");
    }
    
    public void selectOption2(){
    	openDropDownPage();
        Select DropDownSelect = new Select(getDropDownSelector());
        DropDownSelect.selectByVisibleText("Option 2");

    }

    public String getSelectedOption(){
        return new Select(getDropDownSelector()).getFirstSelectedOption().getText();
    }


}