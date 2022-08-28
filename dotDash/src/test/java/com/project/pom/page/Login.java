package com.project.pom.page;

import com.project.pom.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Base {

    By content = By.id("content");
    By username = By.id("username");
    By password = By.id("password");
    By loginButton = By.xpath("//form[contains(@name,'login')]/descendant::i[contains(text(),'Login')]/ancestor::button");
    By logout = By.xpath("//*[@class=\"icon-2x icon-signout\"] ");
    By invalidUser = By.id("flash");

    public Login(WebDriver driver) {
        super(driver);
    }

    public void login(){
        if (isDisplayed(content)){
            sendKeys("tomsmith",username);
            sendKeys("SuperSecretPassword!", password);
            click(loginButton);
        }else {
            System.out.println("Register pages was no found");
        }
    }

    public void failLogin(){
        if (isDisplayed(content)){
            sendKeys("tomsmit",username);
            sendKeys("SuperSecretPassword!", password);
            click(loginButton);
        }else {
            System.out.println("Register pages was no found");
        }
    }

    public String registerMessage(){
        System.out.println(getText(logout));
        return getText(logout);
    }

    public Boolean registerFail(){
        return isDisplayed(invalidUser);
    }
}
