package com.dotdash;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Test6DropDown extends BasePage{
    @Test
    public void testDropDown() {
        driver.get("http://localhost:7080/dropdown");
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        //Select Option 1 by
        dropdown.selectByVisibleText("Option 1");
        dropdown.selectByValue("2");


    }
}