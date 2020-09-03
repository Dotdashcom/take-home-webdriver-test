package com.alp.Tests;

import com.alp.utilities.BrowserFactory;
import com.alp.utilities.UtilWait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenu {

    /*
    ContextMenu: http://localhost:7080/context_menu Right-click in the box to see one called 'the-internet'. Test JavaScript alert text on Right-Click.
    */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/"); //or i can put http://localhost:7080/checkboxes, but i would like to show link.click()

        WebElement link = driver.findElement(By.linkText("Context Menu"));
        UtilWait.wait(1);
        link.click();
        UtilWait.wait(1);

        Actions action = new Actions(driver);
        WebElement elementLocator = driver.findElement(By.id("hot-spot"));
        action.contextClick(elementLocator).perform();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        String text = alert.getText();

        if (text.contentEquals("You selected a context menu")) {
            System.out.println("correct");
        } else {
            System.out.println("in-correct");
        }
        alert.accept();//alert.dismiss();


        //    driver.close();

    }


}
