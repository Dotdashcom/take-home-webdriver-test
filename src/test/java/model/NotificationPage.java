package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NotificationPage extends PageGeneral{

    public NotificationPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement clickComponent() {
        return this.driver.findElement(By.cssSelector(".example a"));
    }

    public WebElement notificationComponent() {
        return this.driver.findElement(By.id("flash"));
    }
}
