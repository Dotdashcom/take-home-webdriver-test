package com.example.testautomation_dotdash.pages;

import com.example.testautomation_dotdash.base.BasePage;
import com.example.testautomation_dotdash.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.example.testautomation_dotdash.base.BaseTest.prop;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver)
    {
        super(driver);
        driver.get(prop.getProperty("baseurl") + "/login");
    }

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "button[class='radius'] i")
    private WebElement loginBtn;

    @FindBy(id = "flash")
    private WebElement banner;


    public void fillUsername(String username){
        this.username.sendKeys(username);
    }

    public void fillPassword(String password){
        this.password.sendKeys(password);
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }

    public void verifyLoginBtnIsEnabled(){
        Assert.assertTrue(loginBtn.isEnabled());
    }

    public void verifyBannerErrorMessage(String message){
        Assert.assertEquals(message, banner.getText());
    }
}
