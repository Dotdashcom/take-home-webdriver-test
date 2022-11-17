package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver webDriver;
    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void setUserName(String userName){
        webDriver.findElement(By.id("username")).sendKeys(userName);
    }

    public void setPassword(String password){
        webDriver.findElement(By.id("password")).sendKeys(password);
    }

    public void clickLogin() {
        WebElement login = webDriver.findElement(By.xpath("//button[@type='submit']"));
        login.click();

    }
}
