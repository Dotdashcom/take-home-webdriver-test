package com.framework.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends PageObjectBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage navigate() {
        driver.navigate().to(prop.getProperty("BASE_URL"));
        return this;
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

}
