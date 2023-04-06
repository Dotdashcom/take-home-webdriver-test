package com.homewebdriver.webpages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    private static String LOGIN_URL="http://localhost:7080/login";

    // Locator for Email Address
    By Username = By.xpath("//input[contains(@id,'username')]");

    // Locator for Password field
    By Password= By.xpath("//input[contains(@id,'password')]");

    // Locator for LogIn Button
    By LogInButton= By.xpath("//button[@type='submit']");

    // Locator for Success Login Message
    By LogInSuccess= By.xpath("//div[contains(@class,'flash success')]");

    // Locator for Failure Login Message
    By LogInFailure= By.xpath("//div[contains(@class,'flash error')]");


    // Method to type EmailId
    public void typeUsername(String Id){
        driver.findElement(Username).sendKeys(Id);
    }

    // Method to type Password
    public void typePassword(String PasswordValue){
        driver.findElement(Password).sendKeys(PasswordValue);
    }

    // Method to click LogIn Button
    public void clickLogIn(){
        driver.findElement(LogInButton).click();
    }
    // Method to login to app
    public void loginToApp(String Username, String Password){
       typeUsername(Username);
       typePassword(Password);
       clickLogIn();
    }

    // Method to verify login success message
    public String getLoginSuccessMessage(){
      return driver.findElement(LogInSuccess).getText().replace("×"," ").trim();
    }

    // Method to verify login failure message
    public String getLoginFailureMessage(){
        return driver.findElement(LogInFailure).getText().replace("×"," ").trim();
    }


    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        driver.get(LOGIN_URL);
        driver.manage().window().maximize();
        //Initialise Elements
        PageFactory.initElements(driver, this);

    }
}
