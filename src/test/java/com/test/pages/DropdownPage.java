package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.test.util.Config;

public class DropdownPage {

    private WebDriver driver;
    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
        driver.get(Config.getUrl("dropdown"));
    }

    public void selectOption1() {
        Select select = new Select(driver.findElement(dropdown));
        select.selectByValue("1");
    }

    public void selectOption2() {
        Select select = new Select(driver.findElement(dropdown));
        select.selectByValue("2");
    }

    public boolean isOption1Selected() {
        Select select = new Select(driver.findElement(dropdown));
        String selectedOption = select.getFirstSelectedOption().getAttribute("value");
        return selectedOption.equals("1");
    }

    public boolean isOption2Selected() {
        Select select = new Select(driver.findElement(dropdown));
        String selectedOption = select.getFirstSelectedOption().getAttribute("value");
        return selectedOption.equals("2");
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

}
