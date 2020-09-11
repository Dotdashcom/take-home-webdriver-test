package com.dashDot;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSuccess extends Main {
    //WebDriver driver = new ChromeDriver();

    public void loginSucess() {
        driver.get("http://localhost:7080/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String title = driver.getTitle();
        //System.out.println(title);
        Assert.assertEquals("The Internet",title);
         if(title.equals("The Internet") ){
             System.out.println("Login is successful");
         }
         else {
             System.out.println("Login Failed. Please enter the valid credentials");
         }


            }
}
