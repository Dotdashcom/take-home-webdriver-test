package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageGeneral{

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement userNameComponent() {
        return this.driver.findElement(By.id("username"));
    }

    public WebElement passwordComponent() {
        return this.driver.findElement(By.id("password"));
    }

    public WebElement loginButtonComponent(){
        return this.driver.findElement(By.className("fa-sign-in"));
    }

}
