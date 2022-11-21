package pages;

import configuration.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void authenticateAs(String user, String password) {
        setURL("http://" + user + ":" + password + "@localhost:7080/basic_auth");
        getURL();
    }
}
