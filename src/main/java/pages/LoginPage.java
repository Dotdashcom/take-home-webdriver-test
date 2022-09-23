package pages;

import core.AbstractWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends AbstractWebPage {

    @FindBy(id = "flash")
    protected WebElement bannerElm;

    @FindBy(id = "username")
    protected WebElement usernameElm;

    @FindBy(id = "password")
    protected WebElement passwordElm;

    @FindBy(css = "#login > button")
    protected WebElement loginButtonElm;



    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void doLogin(String email, String password){
        overrideInput(usernameElm, email);
        overrideInput(passwordElm, password);

        loginButtonElm.click();

        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
    }

    public String getErrorMessage() {
        WebElement errorMsgELm = driver.findElement(By.id("flash"));
        String errorMessage = errorMsgELm.getText().trim();
        return errorMessage;
    }

    public String getFlashBackgroundColor() {
        String backgroundColorValueInHex = bannerElm.getCssValue("background-color");
        return backgroundColorValueInHex;
    }

}