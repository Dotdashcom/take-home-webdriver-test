package org.benjamin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DropDown extends PageBase {
    private String originalWindows;

    public void init() {
        super.init("http://localhost:7080/dropdown");
    }

    public void selectDropDown(String option){
        Select dropDown = new Select(driver.findElement(By.id("dropdown")));
        dropDown.selectByValue(option);
    }

    public String getSelected(){
        WebElement option = driver.findElement(By.cssSelector("#dropdown option[selected='selected']"));
        return option.getAttribute("value");
    }
}
