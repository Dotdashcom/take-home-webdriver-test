package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class JSAlertPage extends PageGeneral{

    public JSAlertPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement alertComponent() {
        return this.driver.findElement(By.cssSelector(".example li:nth-child(1) button"));
    }

    public WebElement confirmComponent() {
        return this.driver.findElement(By.cssSelector(".example li:nth-child(2) button"));
    }

    public WebElement promptComponent() {
        return this.driver.findElement(By.cssSelector(".example li:nth-child(3) button"));
    }

    public WebElement resultComponent() {
        return this.driver.findElement(By.id("result"));
    }
}
