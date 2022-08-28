package com.project.pom.page;

import com.project.pom.Base;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenu extends Base {

    By content = By.id("content");

    public ContextMenu(WebDriver driver) {
        super(driver);
    }

    public void clickOnBox(){
        if (isDisplayed(content)) {
            WebElement box = driver.findElement(By.id("hot-spot"));
            Actions actions = new Actions(driver);
            actions.contextClick(box).build().perform();
        }else {
            System.out.println("Context Menu page was no found");
        }
    }

    public String validateJSAlert(){
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        return message;
    }
}
