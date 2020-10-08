package regression.ui.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class LoginPage extends WebObject {
    public LoginPage(WebDriver driver) throws Exception {
        super(driver);
        this.waitForElementVisibility(By.xpath(this.xpathForPageTitle()));
    }

    public static LoginPage navigateToLoginPage(WebDriver driver, String baseUrl) throws Exception {
        String url = String.format("%s/login", baseUrl);
        driver.get(url);
        return new LoginPage(driver);
    }

    public void enterUsername(String username) {
        WebElement usernameField = driver.findElement(By.xpath(this.xpathForUsername()));
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.xpath(this.xpathForPassword()));
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        WebElement loginButton = driver.findElement(By.xpath(this.xpathForLoginButton()));
        loginButton.click();
    }

    public String getPageTitle() {
        return driver.findElement(By.xpath(this.xpathForPageTitle())).getText();
    }

    public String getErrorMessage() {
        return driver.findElement(By.xpath(this.xpathForErrorMessage())).getText();
    }

    public boolean doesErrorMessageExist() {
        return this.doesElementExist(By.xpath(this.xpathForErrorMessage()));
    }

    private String xpathForUsername() {
        return "//input[@id = \"username\"]";
    }

    private String xpathForPassword() {
        return "//input[@id=\"password\"]";
    }

    private String xpathForLoginButton() {
        return "//button[@type=\"submit\"]";
    }

    private String xpathForPageTitle() {
        return "//h2";
    }

    private String xpathForErrorMessage() {
        return "//*[@class=\"flash error\"]";
    }
}
