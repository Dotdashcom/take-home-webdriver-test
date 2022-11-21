package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class FloatingMenu extends BasePage{


    By floatingMenus= By.xpath("//*[@id='menu']//li");

    public boolean scrollDown()
    {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeAsyncScript("window.scrollBy(0,300)","");
        return driver.findElement(floatingMenus).isDisplayed();

    }


}
