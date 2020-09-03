package com.alp.Tests;

import com.alp.utilities.BrowserFactory;
import com.alp.utilities.UtilWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginSuccess {
    /*
    Login Success: http://localhost:7080/login credentials: tomsmith/SuperSecretPassword!
    */
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/login");

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");
        UtilWait.wait(3);


        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");

        WebElement button = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        button.click();

        WebElement message = driver.findElement(By.className("subheader"));
        String actualmessage = message.getText();
        String expectedmessage = "Welcome to the Secure Area. When you are done click logout below.";
        UtilWait.wait(5);

        WebElement Logout = driver.findElement(By.xpath("//i[@class='icon-2x icon-signout']"));
        Logout.click();

        UtilWait.wait(5);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:7080/login";

        if (expectedmessage.equals(actualmessage) && expectedUrl.equals(actualUrl)) {
            System.out.println("Message is same. Login Test Pass");

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
