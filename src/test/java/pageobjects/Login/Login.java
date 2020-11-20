package pageobjects.Login;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by PSUSHKOV on Nov, 2020
 **/

public class Login {
    protected WebDriver driver;
    private static final long DEFAULT_PAUSE = 2000;

    @FindBy(name = "username")
    public WebElement elUsername;

    @FindBy(name = "password")
    public WebElement elPassword;

    @FindBy(xpath ="//button/i[contains(text(),'Login')]")
    public WebElement elLoginBtn;

    @FindBy(xpath ="//div[@id='flash']")
    public WebElement elFlash;

    public Login(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String loginForm(String username, String password) throws InterruptedException {
        elUsername.sendKeys(username);
        elPassword.sendKeys(password);
        elLoginBtn.click();

        Thread.sleep(DEFAULT_PAUSE);

        return elFlash.getText();
    }

}
