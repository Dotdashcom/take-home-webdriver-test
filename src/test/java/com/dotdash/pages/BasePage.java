package com.dotdash.pages;


import com.dotdash.utilities.Driver;
import org.openqa.selenium.By;

public abstract class BasePage {


    public void navigatePages(String pageName) {

        Driver.getDriver().findElement(By.linkText(pageName)).click();

    }

}
