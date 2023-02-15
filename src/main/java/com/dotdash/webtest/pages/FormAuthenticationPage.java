package com.dotdash.webtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormAuthenticationPage extends WebPage {

    @FindBy(css = "#content > ul > li:nth-child(21) > a")
    protected WebElement formAuthenticationButton;

    @FindBy(id = "username")
    protected WebElement username;

    @FindBy(id = "password")
    protected WebElement password;

    @FindBy(tagName = "i")
    protected WebElement loginButton;

    @FindBy(tagName = "h4")
    protected WebElement suggestionText;

    @FindBy(css = "#content > div > a")
    protected WebElement logoutButton;

    @FindBy(id = "flash")
    protected WebElement loginStatusText;

    public FormAuthenticationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void goToFormAuthenticationPage() {
        formAuthenticationButton.click();
    }

    public void login(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public String getSuggestionMessage() {
        return suggestionText.getText();
    }

    public void clickLogout() {
        logoutButton.click();
    }

    public String getErrorMessage() {
        return loginStatusText.getText();
    }
}
