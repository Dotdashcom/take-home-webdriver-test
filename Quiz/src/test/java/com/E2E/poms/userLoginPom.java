package com.E2E.poms;


import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;


public class userLoginPom {

    private WebDriver driver;

    public userLoginPom(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Call to web element ID's
    @FindBy(id = "username")
    public WebElement usernameInput;

    public void usernameLoginInput(String username){
        this.usernameInput.sendKeys(username);
    }



    @FindBy(id = "password")
    public WebElement passcodeInput;

    public void passcodeLoginInput(String password){
        this.passcodeInput.sendKeys(password);
        
    }

    @FindBy(xpath = "//*[@id='login']/button")
    public WebElement submitLogin;

    public void submitLoginCorrect(){
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        // wait.until(ExpectedConditions.elementToBeClickable(submitLogin));
        this.submitLogin.click();
        
    }

    @FindBy(id = "flash")
    public WebElement errorMessage;

    public void errorMessageDisplayed(){

        Assert.assertNotNull(errorMessage.getText());
    }

    

}
