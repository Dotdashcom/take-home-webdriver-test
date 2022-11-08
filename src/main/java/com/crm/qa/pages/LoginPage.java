package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(id="username")
    WebElement user;

    @FindBy(id="password")
    WebElement password;

    @FindBy(className="fa")
    WebElement button;

    //Initializing the page Objects
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void login(String users, String passwoord){
        driver.get("http://localhost:7080/login");
        user.sendKeys(users);
        password.sendKeys(passwoord);
        button.click();
    }


}
