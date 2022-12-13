package take.home.webdrivertest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

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
    public void testLogin() {
        // test valid credentials
        loginPage.clickElement(loginPage.Username);
        loginPage.sendKeys(loginPage.Username, username);
        loginPage.clickElement(loginPage.Password);
        loginPage.sendKeys(loginPage.Password, password);
        loginPage.clickElement(loginPage.LoginButton);

        // test invalid credentials
        loginPage.clickElement(By.cssSelector(".icon-2x"));
        loginPage.clickElement(loginPage.Username);
        loginPage.sendKeys(loginPage.Username, "foo");
        loginPage.clickElement(loginPage.Password);
        loginPage.sendKeys(loginPage.Password, "bar");
        loginPage.clickElement(loginPage.LoginButton);
    }
}