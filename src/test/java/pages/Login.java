package pages;

import common.POBase;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Login extends POBase {
    public void verifyLoggedIntoApp(String userName, String password){
        enterCredsClickLogin(userName, password);
        verifyLoggedIn();
    }

    public void verifyLoginFailed(String userName, String password){
        enterCredsClickLogin(userName, password);
        verifyFail();
    }

    private void enterCredsClickLogin(String userName, String password){
        enterUserName(userName);
        enterPassword(password);
        clickLogin();
    }

    private void enterUserName(String userName){
        getElement(By.id("username")).sendKeys(userName);
    }

    private void enterPassword(String password){
        getElement(By.id("password")).sendKeys(password);
    }

    private void clickLogin(){
        getElement(By.xpath("//button[@type='submit']")).click();
    }

    private void verifyLoggedIn(){
        Assert.assertTrue(isElementPresent(By.xpath("//h4[text()='Welcome to the Secure Area. When you are done click logout " +
                "below.']")));
    }

    private void verifyFail(){
        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='flash error']")));
    }
}
