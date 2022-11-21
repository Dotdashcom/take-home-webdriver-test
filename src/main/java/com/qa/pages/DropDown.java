package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDown extends BasePage{

    By dropDownList= By.id("dropdown");

    public boolean selectValue(String test)
    {
        boolean selected=false;
        Utility.wait(driver.findElement(dropDownList));
        Select se=new Select(driver.findElement(dropDownList));
        se.selectByVisibleText(test);
         for(WebElement e: se.getOptions())
         {
             if(e.getText().contains(test))
             {
                 if(e.getAttribute("selected").contains("selected"))
                 {
                     selected=true;
                 }
             }
         }
        return selected;
    }
}
