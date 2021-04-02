package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class LoginPage
    {
        WebDriver ldriver;

        public LoginPage(WebDriver rdriver)
        {
            ldriver = rdriver;
            PageFactory.initElements(rdriver, this);
        }

        @FindBy(id = "username")
        WebElement txtUserName;

        @FindBy(id = "password")
        WebElement txtPassword;

        @FindBy(xpath = "//i[contains(text(),'Login')]")
        WebElement BtnLogin;

        public void SetUserName(String Uname) {
            txtUserName.sendKeys(Uname);

        }

        public void SetPassword(String Upwd) {
            txtPassword.sendKeys(Upwd);
        }

        public void ClickLogin() {
            BtnLogin.click();
        }
    }

