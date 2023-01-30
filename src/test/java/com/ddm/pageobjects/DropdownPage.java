package com.ddm.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class DropdownPage extends WebPage {

    protected Select dropDownPickList;

    public DropdownPage (WebDriver remoteDriver) {
        super(remoteDriver);
        dropDownPickList = new Select(driver.findElement(By.id("dropdown")));
    }

    public void select(String option) {
        dropDownPickList.selectByVisibleText(option);
    }

    public String getSelectedOption() {
        return dropDownPickList.getFirstSelectedOption().getText();
    }
}
