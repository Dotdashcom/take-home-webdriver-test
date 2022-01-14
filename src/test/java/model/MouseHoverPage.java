package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MouseHoverPage extends PageGeneral{

    public MouseHoverPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> imagesComponent() {
        return this.driver.findElements(By.cssSelector(".example img"));
    }

    public List<WebElement> contentsComponent() {
        return this.driver.findElements(By.cssSelector(".example h5"));
    }

}
