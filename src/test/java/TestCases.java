import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class TestCases {

    public static WebDriver driver;

    @BeforeTest
    public void setUp() {
        //setting path of chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "C://Users//Kjuri//Documents//Chromedriver//chromedriver.exe");

        //to launch the chrome browser window
        driver = new ChromeDriver();

        //maximize the browser window
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginSuccess() {
        InternetLogin internetLogin = new InternetLogin(driver);
        InternetSecurePage internetSecurePage = new InternetSecurePage(driver);

        // Open Login page
        driver.get(internetLogin.getUrl());

        // Login with username "tomsmith" and password "SuperSecretPassword!"
        internetLogin.login("tomsmith", "SuperSecretPassword!");

        // Verify that the login was successful based on the page URL
        Assert.assertEquals(driver.getCurrentUrl(), internetSecurePage.getUrl());

        // THIS IS IF WE WANT TO USE A WAIT INSTEAD OF JUST ASSERT TO ACCOUNT FOR LOAD TIME
        // Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
        //         .withTimeout(Duration.ofSeconds(10))
        //         .pollingEvery(Duration.ofSeconds(2));
        //
        // wait.until(ExpectedConditions.urlMatches(internetSecurePage.getUrl()));
    }

    @Test
    public void loginFailure() {
        InternetLogin internetLogin = new InternetLogin(driver);

        // Open Login page
        driver.get(internetLogin.getUrl());

        // Test wrong username
        internetLogin.login("fakeUsername", "fakePassword");

        // check if there's a username error
        Assert.assertTrue(internetLogin.hasUsernameError());

        // Test wrong username
        internetLogin.login("tomsmith", "fakePassword");

        // check if there's a password error
        Assert.assertTrue(internetLogin.hasPasswordError());
    }



}