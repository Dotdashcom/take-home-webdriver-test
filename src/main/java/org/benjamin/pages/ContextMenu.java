package org.benjamin.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class ContextMenu {
    public String rightClick(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:7080/context_menu");

        WebElement menuBox = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);
        actions.contextClick(menuBox).perform();

        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        alert.dismiss();

        actions.sendKeys(Keys.ESCAPE).perform();
        driver.close();

        return message;
    }
}
