package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecurePage extends BasePage {
    @FindBy(xpath = "//h4[contains(text(),'Welcome to the Secure Area')]")
    WebElement welcomeMessage;

    public void verifyUserSuccessfullyLogged(){
        Assert.assertTrue("User is not logged", welcomeMessage.isDisplayed());
    }

}
