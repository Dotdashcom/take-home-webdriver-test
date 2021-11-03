package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class LoginPage extends BasicPage {

    WebDriver driver;
    SoftAssert softAssert;

    @FindBy(xpath = "//*[@id='username']")
    WebElement userName;

    @FindBy(xpath = "//*[@id='password']")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"login\"]/button")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("http://localhost:7080/login");
        PageFactory.initElements(driver, this);
        softAssert = new SoftAssert();
    }

    public void enterUsername(String username) {
        userName.sendKeys(username);
    }

    public void enterPassword(String arg1) {
        password.sendKeys(arg1);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void softAssertLoginResult(Boolean shouldFail) {
        WebElement flashElement = null;
        try {
            String xpathFail = "//div[@id=\"flash\"][@class=\"flash error\"]";
            String xpathSuccess = "//div[@id=\"flash\"][@class=\"flash success\"]";
            flashElement = this.driver.findElement(By.xpath(shouldFail ? xpathFail : xpathSuccess));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        softAssert.assertNotNull(null);
    }
}
