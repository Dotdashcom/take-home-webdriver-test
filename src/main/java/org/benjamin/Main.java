package org.benjamin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:7080/login");

        WebElement tbUName = driver.findElement(By.id("username"));
        tbUName.sendKeys("tomsmith");
        WebElement tbPw = driver.findElement(By.id("password"));
        tbPw.sendKeys("SuperSecretPassword!");


        driver.close();
    }
}