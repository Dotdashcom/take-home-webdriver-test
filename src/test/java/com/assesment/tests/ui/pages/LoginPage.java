package com.assesment.tests.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public enum Using{
        USERNAME_FIELD(By.id("username")),
        PASSWORD_FIELD(By.id("password")),
        LOGIN_BUTTON(By.xpath("//button[@type='submit']//i")),
        LOGIN_RESPONSE_MESSAGE(By.id("flash"));

        private final By selector;

        Using(By selector) {
            this.selector = selector;
        }
        public By selector(){
            return this.selector;
        }
    }
    /**
     * Enter username, password and click the logging button
     */
    public void enterUsernameAndPassword(String username, String password){
        driver.findElement(Using.USERNAME_FIELD.selector()).sendKeys(username);
        driver.findElement(Using.PASSWORD_FIELD.selector()).sendKeys(password);
        driver.findElement(Using.LOGIN_BUTTON.selector()).click();
    }
    /**
     *
     * @return
     */
    public String getLoggedInMessage(){
        return driver.findElement(Using.LOGIN_RESPONSE_MESSAGE.selector()).getText();
    }

}
