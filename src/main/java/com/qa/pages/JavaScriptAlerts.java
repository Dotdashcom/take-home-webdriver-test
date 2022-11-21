package com.qa.pages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class JavaScriptAlerts extends BasePage {

    By clickForJSAlert=By.xpath("//button[@onclick='jsAlert()']");

    By clickForJSConfirm=By.xpath("//button[@onclick='jsConfirm()']");

    By clickForJSPrompt=By.xpath("//button[@onclick='jsPrompt()']");

    By result=By.id("result");

    public boolean JSAlertTest() {
        boolean alertsSuccessful=false;
        Utility.wait(driver.findElement(clickForJSAlert));
        driver.findElement(clickForJSAlert).click();
        driver.switchTo().alert().accept();
        boolean jsAlert= driver.findElement(result).getText().contains("You successfuly clicked an alert");

        Utility.wait(driver.findElement(clickForJSConfirm));
        driver.findElement(clickForJSConfirm).click();
        driver.switchTo().alert().accept();
        boolean jsConfirm= driver.findElement(result).getText().contains("You clicked: Ok");

        Utility.wait(driver.findElement(clickForJSPrompt));
        driver.findElement(clickForJSPrompt).click();
        Alert al=driver.switchTo().alert();
        al.sendKeys("it is a prompt alert");
        al.accept();
        boolean jsPrompt= driver.findElement(result).getText().contains("You entered: it is a prompt alert");
        if(jsAlert && jsConfirm && jsPrompt){
            alertsSuccessful=true;
        }
        return alertsSuccessful;
    }

}
