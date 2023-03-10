package com.example.takehomewebdrivertest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private static final String BaseUrl = "http://localhost:7080/";


    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(BaseUrl+"login");
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginSuccess() throws InterruptedException {
        loginPage.login("tomsmith","SuperSecretPassword!");
        //Wait for page update
        Thread.sleep(1000);
        assert(driver.getCurrentUrl().equals(BaseUrl+"secure"));
    }
    @Test
    public void loginFail() throws InterruptedException {
        //User Name
        loginPage.login("alpBasturk","SuperSecretPassword!");
        //Wait for page update
        Thread.sleep(1000);
        assert(driver.getCurrentUrl().equals(BaseUrl+"login"));
        //Password
        loginPage.login("tomsmith","alpBasturk");
        //Wait for page update
        Thread.sleep(1000);
        assert(driver.getCurrentUrl().equals(BaseUrl+"login"));
    }
}



