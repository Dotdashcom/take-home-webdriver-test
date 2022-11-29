package com.dotdash.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    @FindBy(how = How.CSS, using = "#username")
    private WebElement usernameField;

    @FindBy(how = How.CSS, using = "#password")
    private WebElement passwordField;

    @FindBy(how = How.CSS, using = "[id=\"login\"] > button[type=\"submit\"]")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToLoginPage() {
        driver.get(BASEURL + "/login");
        return this;
    }

    public LoginPage loginToApplication(String username, String password) {
        waitForVisibilityOf(usernameField).sendKeys(username);
        waitForVisibilityOf(passwordField).sendKeys(password);
        waitForClickabilityOf(loginButton).click();
        return this;
    }

    public String getAlertMessage(){
        return waitForVisibilityOf(alertElement).getText().replaceAll("\\n.", "");
    }

}
