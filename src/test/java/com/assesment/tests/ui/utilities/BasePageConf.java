package com.assesment.tests.ui.utilities;

import org.openqa.selenium.WebDriver;

public class BasePageConf {

    protected WebDriver navigateToBasePage(){
        WebDriver driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("base_url"));
        return driver;
    }
}

