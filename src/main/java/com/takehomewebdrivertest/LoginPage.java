package com.takehomewebdrivertest;
import com.takehomewebdrivertest.dataprovider.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    ConfigFileReader configFileReader;

    private final String URL = "/login";
    private final String loginTextMsg = "This is where you can log into the secure area. Enter tomsmith for the " +
            "username and SuperSecretPassword! for the password. If the information is wrong you should see error messages.";
    private final By loginText = By.cssSelector("h4.subheader");
    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By signInBtn = By.cssSelector("button[type=\"submit\"]");
    private final By failedMessage = By.id("flash");

    public void navigateToLoginPage() throws Exception {
        configFileReader= new ConfigFileReader();
        driver.get(configFileReader.getBaseUrl() + "/login");
        assertThat(getCurrentUrl()).contains(URL);
        String loginMsg = driver.findElement(loginText).getText();

        assertThat(loginMsg).contains(loginTextMsg);
    }

    public void loginProcess(String user, String password) throws Exception {
        sendKeys(usernameInput, user);
        sendKeys(passwordInput, password);
        click(signInBtn);
    }

    public void validateMessage(String message) throws Exception {
        assertThat(getCurrentUrl()).contains(URL);
        String msgText = driver.findElement(failedMessage).getText();
        assertThat(msgText).contains(message);
    }
}
