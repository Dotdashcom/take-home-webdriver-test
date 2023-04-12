package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(xpath = "//input[@id='username']")
    WebElement usernameInput;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordInput;
    @FindBy(xpath = "//i[contains(text(),'Login')]")
    WebElement loginBtn;
    @FindBy(xpath = "//div[contains(text(),'username is invalid')]")
    WebElement errorMessage;


    public void verifyLoginPage(){
        Assert.assertTrue("User is not on a login page", usernameInput.isDisplayed());
    }
   public void enterValidUsername(){
       usernameInput.sendKeys("tomsmith");
    }
    public void enterValidPassword(){
       passwordInput.sendKeys("SuperSecretPassword!");
    }
    public void clickLoginBtn(){
        loginBtn.click();
    }
    public void enterInvalidUsername(){
        usernameInput.sendKeys(faker.name().firstName());
    }
    public void enterInvalidPassword(){
        passwordInput.sendKeys(faker.internet().password());
    }
    public void verifyUserIsNotLogged(){
        Assert.assertTrue("User is not logged", errorMessage.isDisplayed());
    }


}
