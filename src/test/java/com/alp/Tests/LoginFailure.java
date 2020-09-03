package com.alp.Tests;

import com.alp.utilities.BrowserFactory;
import com.alp.utilities.UtilWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginFailure {
    /*
Login Failure: http://localhost:7080/login Login fail invalid creadentials
    */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://localhost:7080/login");

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("smithtom");
        UtilWait.wait(3);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");

        WebElement button = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        button.click();

        WebElement message = driver.findElement(By.className("subheader"));
        String actualmessage = message.getText();
        String expectedmessage = "This is where you can log into the secure area. Enter tomsmith for the username and SuperSecretPassword! for the password. If the information is wrong you should see error messages.";
        UtilWait.wait(5);

        UtilWait.wait(5);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:7080/login";

        if (expectedmessage.equals(actualmessage) && expectedUrl.equals(actualUrl)) {
            System.out.println("Message is same. LoginFailure Test Pass");

        } else {
            System.out.println("fail");
            System.out.println("actual message : " + actualmessage);
            System.out.println("expected message : " + expectedmessage);
            System.out.println("expected url : " + expectedUrl);
            System.out.println("actual url : " + actualUrl);
        }
        UtilWait.wait(2);

        //    driver.close(); //if u want//

    }

}

