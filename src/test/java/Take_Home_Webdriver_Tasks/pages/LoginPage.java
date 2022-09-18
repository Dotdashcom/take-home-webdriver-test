package Take_Home_Webdriver_Tasks.pages;

import Take_Home_Webdriver_Tasks.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy (id ="username")
    public WebElement usernameBox;

    @FindBy (id ="password")
    public WebElement passwordBox;

    @FindBy(xpath = " //button[@type='submit'] ")
    public WebElement loginButton;

    @FindBy (xpath = "//*[@id='flash']")
    public WebElement loginPageMsg;


    public void login(String username,String password) {
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();
    }
    public void loginDynamically(String userType) {

        String username = ConfigurationReader.getProperty(userType + ".username");
        String password = ConfigurationReader.getProperty(userType + ".password");


        login(username,password);
    }


}
