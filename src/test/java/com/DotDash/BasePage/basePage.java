package com.DotDash.BasePage;

import com.DotDash.Utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class basePage {

    ReadConfig readconfig = new ReadConfig();
    public String baseURL=readconfig.getAppURL();
    public String username=readconfig.getUsername();
    public String password=readconfig.getPassword();

    public WebDriver driver;
    @BeforeClass
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}