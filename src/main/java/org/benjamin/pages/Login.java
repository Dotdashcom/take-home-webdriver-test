package org.benjamin.pages;

import org.benjamin.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
    public String login(String username, String password){
        WebDriver driver = Utils.startDriver();
        driver.get("http://localhost:7080/login");

        WebElement tbUName = driver.findElement(By.id("username"));
        tbUName.sendKeys(username);
        WebElement tbPw = driver.findElement(By.id("password"));
        tbPw.sendKeys(password);

        WebElement btnSubmit = driver.findElement(By.className("radius"));
        btnSubmit.click();

        WebElement alert = driver.findElement(By.id("flash"));
        String classNames = alert.getAttribute("class");

        driver.close();

        return classNames;
    }
}
