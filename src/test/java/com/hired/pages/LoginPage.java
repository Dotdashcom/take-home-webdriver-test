package com.hired.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
   public WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(css="button[class='radius']")
    public WebElement submit;

    @FindBy(css="div[class='flash success']")
    public WebElement successMessage;
    @FindBy(id="flash")
    public WebElement errorMessage;

    public void login(String user, String pass){
        username.sendKeys(user);
        password.sendKeys(pass);
        submit.click();

    }
}
