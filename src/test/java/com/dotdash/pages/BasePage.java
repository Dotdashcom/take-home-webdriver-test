package com.dotdash.pages;
import com.dotdash.utilities.DriverUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


public abstract class  BasePage {
    public BasePage() {
        PageFactory.initElements(DriverUtils.getDriver(), this);
    }


        public void navigatePages(String pageName) {

            DriverUtils.getDriver().findElement(By.linkText(pageName)).click();

        }
}
