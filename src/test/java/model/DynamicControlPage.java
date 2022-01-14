package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicControlPage extends PageGeneral{

    public DynamicControlPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public int checkboxComponents() {
        return this.driver.findElements(By.id("checkbox")).size();
    }

    public WebElement removeAddComponent() {
        return this.driver.findElement(By.cssSelector("button[onclick='swapCheckbox()']"));
    }

    public WebElement disableEnableComponent() {
        return this.driver.findElement(By.cssSelector("button[onclick='swapInput()']"));
    }

    public WebElement textComponent() {
        return this.driver.findElement(By.cssSelector("input[style='width: 30%;']"));
    }



}
