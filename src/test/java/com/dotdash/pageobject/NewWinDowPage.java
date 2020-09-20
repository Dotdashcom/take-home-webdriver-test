package com.dotdash.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NewWinDowPage {
    private WebDriver driver;

    private By only_text_on_page = By.cssSelector("h3");

    public NewWinDowPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verify_text_on_new_window(String expected_text) {
        String actual_text_on_window = driver.findElement(only_text_on_page).getText();
        Assert.assertEquals(expected_text, actual_text_on_window, "[ERR] Text on new window is incorrect!");
    }
}
