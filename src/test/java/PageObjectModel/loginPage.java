package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import utilities.Driver;

public class loginPage {
    WebDriver driver;

    public loginPage() {

        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    private WebElement username;


    @FindBy(id = "password")
    private WebElement password;


    @FindBy(xpath = " //i[\" Login\"]")
    private WebElement login;

    @FindBy(css = ".flash")
    private WebElement successMessage;

    @FindBy(id = "flash")
    private WebElement errorMessage;


    public void typeUsername() {
        username.sendKeys("tomsmith");

    }

    public void typeInvalidUsername() {
        username.sendKeys("Tomsmith12");
    }

    public void typePassword() {
        password.sendKeys("SuperSecretPassword!");

    }

    public void clickOnLogin() {

        //
        login.click();

    }


    public void assertionMethode() {

        Assert.assertTrue(successMessage.getText().trim().contains("You logged into a secure area!"));

        System.out.println("Success");
    }

    public void assertionMethodeNegative() {
        Assert.assertTrue(errorMessage.getText().trim().contains("invalid"));

    }


}


