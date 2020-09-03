package com.alp.Tests;

import com.alp.utilities.BrowserFactory;
import com.alp.utilities.UtilWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControls {

    /*
    Dynamic Controls: http://localhost:7080/dynamic_controls Test Dynamic Controls using Explicit Waits.
    */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://localhost:7080/");
        WebElement link = driver.findElement(By.linkText("Dynamic Controls"));
        UtilWait.wait(1);
        link.click();
        UtilWait.wait(1);
/*There is no one size fits all solution to this problem. We have to understand the application very well
            I use custom xpaths, linkText and css locators
        - Xpath: contains, starts with, ends with, contains text.
        - By finding the element in relation to another stable element using parent, child, sibling relationships
*/
        driver.findElement(By.xpath("//div[@id='checkbox']//input")).click();
        UtilWait.wait(1);
        driver.findElement(By.xpath("//button[contains(text(),'Remove')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("message")));

        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/form[2]/button[1]")).click();


        //    driver.close();

    }

}
