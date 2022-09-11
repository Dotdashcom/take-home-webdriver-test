package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {


      public LoginPage(WebDriver driver){
            PageFactory.initElements(driver,this);
      }

      @FindBy(id="username")
      WebElement username;

      @FindBy(id="password")
      WebElement password;

      @FindBy(xpath = "//button[@type='submit']")
      WebElement loginButton;

      @FindBy(id = "flash")
      WebElement errorMsg;


      public void sendInfo(String username, String password) throws InterruptedException {

            this.username.sendKeys(username);
            this.password.sendKeys(password);
            Thread.sleep(2000);
            loginButton.click();
      }

      public void sendWrongInfo(){
            String actualMsg =errorMsg.getText().replaceAll("×","").trim();
            String expectedMsg ="Your password is invalid!";

            Assert.assertEquals(actualMsg, expectedMsg );


      }





}
