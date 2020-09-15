package framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SecureAreaPage {

    WebDriver driver;

    @FindBy(id = "flash")
    WebElement loginSuccessfulMessage;

    @FindBy(xpath = "//*[@id='content']/div/a")
    WebElement logOut;


    public void verifyLoginSuccessful() {
        Assert.assertEquals(true,loginSuccessfulMessage.isDisplayed() );
    }

    public void logout(){
        logOut.click();
    }
}
