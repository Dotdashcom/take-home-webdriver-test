package com.nparede.project.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage{

    @FindBy(id = "username")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(className = "radius")
    private WebElement loginButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void fillUserInput(String userName) {
        System.out.println("Login Page | Sending keys for username: "+userName);
        this.loginInput.sendKeys(userName);
    }

    public void fillPasswordInput(String password) {
        System.out.println("Login Page | Sending keys for password: "+password);
        this.passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        System.out.println("Login Page | Clicking on login button.");
        this.loginButton.click();
    }
}
