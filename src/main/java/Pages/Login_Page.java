package Pages;

import Helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;

public class Login_Page {
    public WebDriver driver;
    public Helpers helpers;

    public Login_Page(WebDriver driver){
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    // WEB ELEMENT // WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT

    public By username_input = By.id("username");
    public By password_input = By.id("password");
    public By login_Button = By.xpath("//button[@type='submit']");
    public By message_flash_div =  By.id("flash");


    // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES

    public void GoToLoginPage(){
        driver.navigate().to(driver.getCurrentUrl()+"login");
    }
    public void Perform_Successful_Login(){

        helpers.sendText(username_input, helpers.getXMLParameter("username"));
        helpers.sendText(password_input, helpers.getXMLParameter("password"));
        helpers.Click(login_Button);
        AssertJUnit.assertFalse(helpers.getText(message_flash_div).contains("You logged out of the secure area!"));
    }
    public void Perform_Failing_Login(){

        helpers.sendText(username_input, helpers.getXMLParameter("username"));
        helpers.sendText(password_input, "wrongpassword");
        helpers.Click(login_Button);
        AssertJUnit.assertFalse(helpers.getText(message_flash_div).contains("Your username is invalid!"));
    }

}
