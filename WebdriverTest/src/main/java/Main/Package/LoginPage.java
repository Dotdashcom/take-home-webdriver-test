package Main.Package;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By usernameField = By.xpath("//input[@id='username']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By logInButton = By.xpath("//i[contains(text(),'Login')]");
    private By headingText = By.xpath("//h2[contains(text(),'Login Page')]");
    private By errorText = By.xpath("//div[@id='flash']");

    private By successMessageLoggedInText1 = By.xpath("//div[@id='flash']");
    private By successMessageLoggedInText2 = By.xpath("//h4[contains(text(),'Welcome to the Secure Area. When you are done clic')]");


    public LoginPage typeUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage logInWithInvalidCreds(String username, String password) {
        this.typeUsername(username);
        this.typePassword(password);
        driver.findElement(logInButton).click();
        return new LoginPage(driver);
    }

    public String getHeadingText() {
        return driver.findElement(headingText).getText();
    }

    public String getErrorText() {
        return driver.findElement(errorText).getText();

    }

    public String getSuccessMessageLogIn1() {
        return driver.findElement(successMessageLoggedInText1).getText();
    }

    public String getSuccessMessageLogIn2() {
        return driver.findElement(successMessageLoggedInText2).getText();
    }

}


