package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IframePage extends PageGeneral{

    public IframePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement textboxComponent() {
        return this.driver.findElement(By.id("tinymce"));
    }

    public WebElement fileComponent() {
        return this.driver.findElement(By.className("tox-mbtn__select-label"));
    }

    public WebElement newDocComponent() {
        return this.driver.findElement(By.className("tox-collection__item-label"));
    }
}
