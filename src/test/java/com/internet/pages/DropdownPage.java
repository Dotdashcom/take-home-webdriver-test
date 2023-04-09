package com.internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage{



    WebElement dropdown = driver.findElement(By.id("dropdown"));
    Select dropdownMenu = new Select(dropdown);

    public void selectOptions(String option){
        if(option.equals("Option 1")){
            dropdownMenu.selectByIndex(1);
        }
        else
            dropdownMenu.selectByIndex(2);
    }

    public boolean checkWhichSelected(String option)
    {
        String xpath= "//option[@selected='selected']";
        WebElement selected = driver.findElement(By.xpath(xpath));
        return selected.getText().equals(option);
    }
}
