package com.alp.Tests;

import com.alp.utilities.BrowserFactory;
import com.alp.utilities.UtilWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpeninNewTab {

    /*
    Open in New Tab: http://localhost:7080/windows Test Link Opens in new tab.
    */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/");
        UtilWait.wait(1);

        WebElement link = driver.findElement(By.linkText("Multiple Windows"));
        UtilWait.wait(1);
        link.click();
        driver.findElement(By.linkText("Click Here")).click();


        //    driver.close();

    }
}
