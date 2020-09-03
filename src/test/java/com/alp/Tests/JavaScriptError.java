package com.alp.Tests;

import com.alp.utilities.BrowserFactory;
import com.alp.utilities.UtilWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptError {

    /*
    JavaScript Error: http://localhost:7080/javascript_error Test JS error.
    */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://localhost:7080/");


        WebElement link = driver.findElement(By.linkText("JavaScript onload event error"));
        UtilWait.wait(1);
        link.click();


        //    driver.close();

    }

}
