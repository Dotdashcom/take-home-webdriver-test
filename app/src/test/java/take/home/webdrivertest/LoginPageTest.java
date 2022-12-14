package take.home.webdrivertest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageTest {

    private WebDriver driver;
    //private Map<String, Object> vars;
    //JavascriptExecutor js;

    private LoginPage loginPage;
    private final String username = "tomsmith";
    private final String password = "SuperSecretPassword!";

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/test/res/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/login");

        //js = (JavascriptExecutor) driver;
        //vars = new HashMap<String, Object>();

        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testLogin() throws Exception {
        // test valid credentials
        loginPage.clickElement(loginPage.username);
        loginPage.sendKeys(loginPage.username, username);
        loginPage.clickElement(loginPage.password);
        loginPage.sendKeys(loginPage.password, password);
        loginPage.clickElement(loginPage.loginButton);

        assert loginPage.getLoginResult().contains("You logged into a secure area!");

        // test invalid credentials
        this.setUp();
        loginPage.clickElement(loginPage.username);
        loginPage.sendKeys(loginPage.username, "foo");
        loginPage.clickElement(loginPage.password);
        loginPage.sendKeys(loginPage.password, "bar");
        loginPage.clickElement(loginPage.loginButton);

        assert loginPage.getLoginResult().contains("Your username is invalid!");
    }
}