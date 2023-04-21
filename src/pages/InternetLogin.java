import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InternetLogin {
    private static WebDriver driver;

    private String path = "/login";
    private By usernameFieldBy = By.xpath("//input[@id='username']");
    private By passwordFieldBy = By.xpath("//input[@id='password']");
    private By submitButtonBy = By.xpath("//button[@type='submit']");
    private By errorMessageBy = By.xpath("//div[@id='flash']");
    private By usernameErrorMessageBy = By.xpath("//div[@id='flash' and contains(text(),'Your username is invalid')]");
    private By passwordErrorMessageBy = By.xpath("//div[@id='flash' and contains(text(),'Your password is invalid')]");

    private String usernameStr = "tomsmith";
    private String passwordStr = "SuperSecretPassword!";

    InternetLogin(WebDriver webdriver) {
        driver = webdriver;
    }

    public String getUrl() {
        InternetBase internetBase = new InternetBase();
        String url = internetBase.getBaseUrl() + path;
        return url;
    }

    public void setUsername(String strUsername) {
        driver.findElement(usernameFieldBy).sendKeys(strUsername);
    }

    public void setPassword(String strPassword) {
        driver.findElement(passwordFieldBy).sendKeys(strPassword);
    }

    public void clickLoginSubmit() {
        driver.findElement(submitButtonBy).click();
    }

    public void login(String strUsername, String strPassword) {
        setUsername(strUsername);
        setPassword(strPassword);
        clickLoginSubmit();
    }

    public String getErrorMessage() {
        String msg = driver.findElement(errorMessageBy).getText();
        System.out.println(msg);
        return msg;
    }

    public boolean hasUsernameError() {
        return driver.findElements(usernameErrorMessageBy).size() > 0;
    }
    public boolean hasPasswordError() {
        return driver.findElements(passwordErrorMessageBy).size() > 0;
    }


}
