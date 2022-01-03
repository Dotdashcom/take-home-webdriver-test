package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage{
    
    WebDriver webDriver;
    String loginPageUrl = "http://localhost:7080/login";

    String usernameXpath = "//input[@id='username']";
    String passwordXpath = "//input[@id='password']";
    String loginButtonXpath = "//button[@type='submit']";
    String loginMessageXpath = "//div[@id='flash']";

    public LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriver.get(loginPageUrl);
    }

    public void setUsername(String username){
        webDriver.findElement(By.xpath(usernameXpath)).sendKeys(username);
    }

    public void setPassword(String password){
        webDriver.findElement(By.xpath(passwordXpath)).sendKeys(password);
    }

    public void clickLoginButton() throws InterruptedException{
        webDriver.findElement(By.xpath(loginButtonXpath)).click();
        Thread.sleep(1000);
    }

    public boolean isLoginSuccess(){
        String loginMessage = webDriver.findElement(By.xpath(loginMessageXpath)).getText();
        return loginMessage.contains("You logged into a secure area!");
    }

    public boolean isLoginFailure(){
        String loginMessage = webDriver.findElement(By.xpath(loginMessageXpath)).getText();
        return loginMessage.contains("Your username is invalid!");
    }
}



