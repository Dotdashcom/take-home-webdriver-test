package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicLoadingPage extends PageGeneral{

//    WebDriver webDriver;

    public DynamicLoadingPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public WebElement buttonComponent() {
        return this.driver.findElement(By.cssSelector("#start button"));
    }

    public WebElement textComponent() {
        return this.driver.findElement(By.cssSelector("#finish h4"));
    }
}
