package com.alp.Tests;

import com.alp.utilities.BrowserFactory;
import com.alp.utilities.UtilWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicContent {

    /*
    Dynamic Content: http://localhost:7080/dynamic_content Test content changes with page reload.
    */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/");

        WebElement link = driver.findElement(By.linkText("Dynamic Content"));
        UtilWait.wait(1);
        link.click();
        UtilWait.wait(1);

        /*There is no one size fits all solution to this problem. We have to understand the application very well
            I use custom xpaths, linkText and css locators
        - Xpath: contains, starts with, ends with, contains text.
        - By finding the element in relation to another stable element using parent, child, sibling relationships*/

        WebElement refresh = driver.findElement(By.linkText("click here"));
        refresh.click();

        //    driver.close();

    }

}
