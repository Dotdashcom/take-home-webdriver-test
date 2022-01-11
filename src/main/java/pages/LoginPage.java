package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage{
    WebDriver driver;

    String baseUrl =("http://localhost:7080/login");
    String secureUrl =("http://localhost:7080/secure");
    By userName = By.id("username");
    By password = By.id("password");
    String loginXpath = "//button[@type='submit']";


    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.driver.get(baseUrl);
    }

    public void setUsername(String strUserName){
        driver.findElement(userName).sendKeys(strUserName);
    }

    public void setPassword(String strPassword){
        driver.findElement(password).sendKeys(strPassword);
    }

    public void clickLogin(){
        driver.findElement(By.xpath(loginXpath)).click();

    }

    public boolean isLoginSuccess(){
        String currentUrl= driver.getCurrentUrl();
        return currentUrl.equals(secureUrl);
    }

    public boolean isLoginFailure(){
        String currentUrl= driver.getCurrentUrl();
        return currentUrl.equals(baseUrl);
    }
}