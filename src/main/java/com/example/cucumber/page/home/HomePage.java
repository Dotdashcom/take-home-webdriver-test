package com.example.cucumber.page.home;

import com.example.navigation.WebDriverJavaUtil;
import com.example.utils.ReadProperties;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class HomePage extends WebDriverJavaUtil {
    WebDriver driver;
    static ReadProperties readProperties = new ReadProperties();
    private static final String HOME_PAGE_TITLE = "The Internet";
    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void navigateToHomePage() {
        driver.get(readProperties.getUrl());
    }

    public void verifyHomePage() {
        System.out.println(driver.getTitle());
        assertEquals("Application Title Doesn't Match: ", HOME_PAGE_TITLE, driver.getTitle());
    }
}
