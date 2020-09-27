import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver drive) {
        driver = drive;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    public WebElement usInput;

    @FindBy(id = "password")
    public WebElement pswdInput;

    @FindBy(id = "login")
    public WebElement loginInput;

}