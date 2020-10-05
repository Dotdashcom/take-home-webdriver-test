package DotDashPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    public WebDriver ldriver;
    public LoginPage(WebDriver rdriver)
    {
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }

    //Capture username field
    @FindBy(id = "username")
    WebElement txtusername;

    //Capture password field
    @FindBy(id = "password")
    WebElement txtpassword;

    //Capture login button
    @FindBy(xpath = "//i[contains(text(),'Login')]")
    WebElement btnLogin;

    //Capture the login success text
    @FindBy(xpath = "//div[@id='flash']")
    WebElement msgLogin;

    //Pass the username value
    public void setTxtusername(String uname)
    {

        txtusername.sendKeys(uname);
    }
    //Pass the password value
    public void setTxtpassword(String pwd)
    {

        txtpassword.sendKeys(pwd);
    }

    //Click the login button
    public void clkbtnLogin()
    {
        btnLogin.click();
    }

    //Return the success message
    public String txtmsgLogin()
    {
        return msgLogin.getText();
    }


}

