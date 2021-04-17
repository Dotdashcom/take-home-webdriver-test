package PageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {

    public WebDriver driver;

    public LoginPageObjects(WebDriver driver) {
        this.driver = driver;
    }

    By username = By.id("username");
    By password = By.id("password");
    By loginButton = By.className("radius");
    By confirmation = By.className("subheader");
    By failedConfirmation = By.xpath("//div[@class='flash error']");


    public WebElement getUsername(){
        return driver.findElement(username);
    }

    public WebElement getPassword(){
        return driver.findElement(password);
    }

    public WebElement getLoginButton(){
        return driver.findElement(loginButton);
    }

    public WebElement getConfirmation(){
        return driver.findElement(confirmation);
    }

    public WebElement getFailureConfirmation(){
        return driver.findElement(failedConfirmation);
    }



}
