package org.benjamin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoading {

    public String clickStart() {
        WebDriver driver = new ChromeDriver();
        try{
            driver.get("http://localhost:7080/dynamic_loading/2");

            WebElement button = driver.findElement(By.cssSelector("#start>button"));
            button.click();

            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));

            WebElement finish = driver.findElement(By.id("finish"));
            return finish.getText();
        }finally {
            driver.close();
        }
    }
}
