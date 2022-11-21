package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage{
    By loginSuccessMessage= By.cssSelector("#flash");
    public boolean isLoggedIn()
    {
        return driver.findElement(loginSuccessMessage).isDisplayed();
    }




}
