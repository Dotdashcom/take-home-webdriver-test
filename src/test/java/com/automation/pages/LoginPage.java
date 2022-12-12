package com.automation.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//a[@href='/basic_auth']")
    WebElement link;

    @FindBy(id = "username")
    WebElement userName;

    @FindBy(id = "password")
    WebElement passWord;

    @FindBy(xpath = "//i[@class='fa fa-2x fa-sign-in']")
    WebElement loginButton;

    @FindBy(id = "flash")
    WebElement text;

    public void clickOnLink() {
        link.click();
    }

    public void loginWithValidCredentials() {
        userName.sendKeys("tomsmith");
        passWord.sendKeys("SuperSecretPassword!");
        loginButton.click();
        Assert.assertTrue(text.isDisplayed());
    }

    public void loginWithInvalidCredentials() {
        Faker faker = new Faker();

        userName.sendKeys(faker.funnyName().name());
        passWord.sendKeys(faker.gameOfThrones().character());
        loginButton.click();
        Assert.assertTrue(text.isDisplayed());
    }
}
