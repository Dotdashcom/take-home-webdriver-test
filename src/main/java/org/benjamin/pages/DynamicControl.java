package org.benjamin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DynamicControl {
    private static String url = "http://localhost:7080/dynamic_controls";
    private WebDriver driver;

    public void init() {
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        this.driver = driver;
    }

    public void destroy(){
        driver.close();
    }

    public boolean clickRemoveOrAddButton() {
        WebElement button = driver.findElement(By.cssSelector("#checkbox-example>button"));
        button.click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading"))));

        List<WebElement> checkbox = driver.findElements(By.cssSelector("#checkbox-example input[type=checkbox]"));

        return checkbox.size() == 0;
    }

    public String clickDisableEnableButton(){

        WebElement button = driver.findElement(By.cssSelector("#input-example>button"));
        button.click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.attributeToBe(button, "disabled", ""));

        WebElement input = driver.findElement(By.cssSelector("#input-example>input[type=text]"));
        String disabled = input.getAttribute("disabled");

        return disabled;
    }
}
