package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class DropdownPage extends PageGeneral {

    public DropdownPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public WebElement dropdownComponent() {
        return this.driver.findElement(By.id("dropdown"));
    }
}
