package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DragDropPage extends PageGeneral {

    public DragDropPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement elementA() {
        return this.driver.findElement(By.id("column-a"));
    }

    public WebElement elementB() {
        return this.driver.findElement(By.id("column-b"));
    }
}
