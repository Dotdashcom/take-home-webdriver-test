import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import POM.LoginPage;
import POM.SecurePage;

public class LoginFailure {

        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();


        @BeforeTest
        public void setUp() throws Exception {
            System.setProperty("webdriver.chrome.driver","BrowserWebDrivers\\chromedriver.exe");

            driver = new ChromeDriver();
            baseUrl = "http://localhost:7080/";
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        }

        @Test
        public void TestLogin() throws Exception {
            driver.get(baseUrl + "login");
            Thread.sleep(2000);
            //Creating object of Login page
            LoginPage login = new LoginPage(driver);
            //Creating object of Dashboard
            SecurePage secureArea = new SecurePage(driver);
            //Enter username & password
            login.enterUsername("tomsmith");
            login.enterPassword("InvalidPassword");

            //Click on login button
            login.clickLogin();
            Thread.sleep(3000);

            String expectedHeading = "Login Page";
            String actualHeading = login.getHeading();
            Assert.assertEquals(actualHeading, expectedHeading);

        }

        @AfterTest
        public void tearDown() throws Exception {
            driver.quit();
        }

}