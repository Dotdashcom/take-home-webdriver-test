package com.alp.Tests;

import com.alp.utilities.BrowserFactory;
import com.alp.utilities.UtilWait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptAlerts {

    /*
    JavaScript Alerts: http://localhost:7080/javascript_alerts Test confirm JS Alert.
    */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://localhost:7080/");

        WebElement link = driver.findElement(By.linkText("JavaScript Alerts"));
        UtilWait.wait(1);
        link.click();

        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
        Alert alert = (Alert) driver.switchTo().alert();
        alert.accept();
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
        alert.dismiss();
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
        alert.getText();
        alert.sendKeys("DotDashCom rocks!");
        alert.accept();


        //    driver.close();

    }

}
