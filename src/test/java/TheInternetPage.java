import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TheInternetPage extends PageObject
{
    private final String USERNAME = "tomsmith";
    private final String PASSWORD = "SuperSecretPassword!";

    @FindBy(id = "username")
    public WebElement user_name;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//i[contains(text(),'Login')]")
    public WebElement login_button;

    @FindBy(xpath = "//div[contains(text(),'You logged into a secure area!')]")
    public WebElement secure_area;

    @FindBy(xpath = "//div[contains(text(),'Your password is invalid!')]")
    public WebElement Invalid_area;



    public TheInternetPage(WebDriver driver)
    {
        super(driver);
    }

    //Login Success
    public void ValidLogin()
    {
        this.user_name.sendKeys(USERNAME);
        this.password.sendKeys(PASSWORD);

        this.login_button.click();
    }

    //Login Failure
    public void InvalidLogin()
    {
        this.user_name.sendKeys(USERNAME);
        this.password.sendKeys("abc123");

        this.login_button.click();
    }
}
