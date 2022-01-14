package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicContentPage extends PageGeneral {

    public DynamicContentPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public WebElement contentComponent() {
        return this.driver.findElement(By.id("content"));
    }
}
