package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage {

    WebDriver driver;

    @FindBy(id="dropdown")
    WebElement dropdown;

    //Initializing the page Objects
    public DropDownPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public ISelect Dropdown(){
        driver.get("http://localhost:7080/dropdown");
        Select select = new Select(driver.findElement(By.id("dropdown")));

        return select;
    }


}
