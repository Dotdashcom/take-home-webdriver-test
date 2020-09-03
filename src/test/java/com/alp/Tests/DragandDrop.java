package com.alp.Tests;

import com.alp.utilities.BrowserFactory;
import com.alp.utilities.UtilWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {

    /*
    Drag and Drop: http://localhost:7080/drag_and_drop Perofrm Drag And Drop in a Webdriver test.
    */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/"); //or i can put http://localhost:7080/checkboxes, but i would like to show link.click()

        WebElement link = driver.findElement(By.linkText("Drag and Drop"));
        UtilWait.wait(1);
        link.click();
        UtilWait.wait(1);

        Actions act = new Actions(driver);
        act.clickAndHold(driver.findElement(By.id("column-a"))).
                moveToElement(driver.findElement(By.xpath("//div[@id='column-b']")))
                .release()
                .build()
                .perform();

        //    driver.close();

    }


}
