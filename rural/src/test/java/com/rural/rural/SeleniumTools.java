package com.rural.rural;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTools {

    public static void selectFromListForVisibleText(WebElement element, String visibleText){
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

}
