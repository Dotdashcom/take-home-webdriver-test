package com.qa.pages;

import org.openqa.selenium.By;

public class JavaScriptError extends BasePage{
    By errorMessage= By.xpath("//p");

    public boolean isError()
    {
        Utility.wait(driver.findElement(errorMessage));
        return driver.findElement(errorMessage).isDisplayed();
    }





}
