package org.benjamin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class MouseHover extends PageBase{
    private Actions actions;

    public void init(){
        super.init("http://localhost:7080/hovers");
        actions = new Actions(driver);
    }

    public void hover(int number){
        List<WebElement> figures = driver.findElements(By.className("figure"));
        WebElement figure = figures.get(number - 1);
        actions.moveToElement(figure).perform();
    }

    public boolean isMessageDisplayed(int number){
        WebElement displayed = driver.findElements(By.className("figure")).get(number - 1);
        return displayed.findElement(By.className("figcaption")).isDisplayed();
    }
}
