package com.alp.Tests;

import com.alp.utilities.BrowserFactory;
import com.alp.utilities.UtilWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

    /*
Dropdown: http://localhost:7080/dropdown Test dropdown using Webdriver.
    */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://localhost:7080/");

        WebElement link = driver.findElement(By.linkText("Dropdown"));
        UtilWait.wait(1);
        link.click();
        UtilWait.wait(1);

        Select select = new Select(driver.findElement(By.id("dropdown")));
        //select.selectByIndex(1);//
        select.selectByVisibleText("Option 2");
        UtilWait.wait(1);
        driver.navigate().back();

    }

}
