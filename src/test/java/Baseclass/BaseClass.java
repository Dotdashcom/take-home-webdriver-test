package Baseclass;

import Helpers.Helpers;
import Helpers.BrowserConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowserConfig browserConfig = new BrowserConfig();
        this.driver = browserConfig.setUpBrowser(new Helpers().getXMLParameter("browser"));
        Helpers helpers = new Helpers(driver);
        helpers.getURL(helpers.getXMLParameter("url"));
    }

    @AfterMethod
    public void Finished(){
        driver.quit();
    }


}
