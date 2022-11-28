package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    //Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By username = By.id("username");
    By password = By.id("password");
    By loginBtn = By.className("radius");
    By heading = By.cssSelector("h2");

    public void enterUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public String getHeading() {
        String head = driver.findElement(heading).getText();
        return head;
    }

}