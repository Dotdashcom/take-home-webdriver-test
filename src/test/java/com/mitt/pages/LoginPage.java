package com.mitt.pages;

import com.mitt.core.BasePage;
import com.mitt.core.PropertyFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private final By userName_xpath = By.xpath("//input[@id = 'username']");
    private final By password_xpath = By.xpath("//input[@id='password']");
    private final By submit_xpath = By.xpath("//button[@type='submit']");
    private final By pageTitile_xpath = By.xpath("//h2");
    private final By errorLoginPage_xpath = By.xpath("//*[@id='flash-messages']");


    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void login(String Username, String Password) {
        getDriver().get(PropertyFileReader.getInstance().getProperty("login_url"));
        this.enterUsername(Username);
        this.enterPasssword(Password);
        this.clickSubmit();
    }

    private void enterUsername(String Username) {
        getDriver().findElement(userName_xpath).sendKeys(Username);
    }

    private void enterPasssword(String Password) { getDriver().findElement(password_xpath).sendKeys(Password); }

    private void clickSubmit() {
        getDriver().findElement(submit_xpath).click();
    }

    public String getPageTitle() { return getDriver().findElement(pageTitile_xpath).getText(); }

    public String getErrorTextOnLoginPage() { return getDriver().findElement(errorLoginPage_xpath).getText(); }
}