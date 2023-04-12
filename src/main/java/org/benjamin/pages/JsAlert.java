package org.benjamin.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class JsAlert extends PageBase{
    public void init(){
        super.init("http://localhost:7080/javascript_alerts");
    }

    public void clickAlert(){
        WebElement btnAlert = driver.findElement(By.cssSelector("button[onclick=\"jsAlert()\"]"));
        btnAlert.click();
        driver.switchTo().alert().dismiss();
    }

    public void clickConfirm(){
        WebElement btnConfirm = driver.findElement(By.cssSelector("button[onclick=\"jsConfirm()\"]"));
        btnConfirm.click();
        driver.switchTo().alert().accept();
    }

    public void inputPrompt(String text){
        WebElement btnConfirm = driver.findElement(By.cssSelector("button[onclick=\"jsPrompt()\"]"));
        btnConfirm.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }

    public String getAlertMessage(){
        return driver.findElement(By.id("result")).getText();
    }
}
