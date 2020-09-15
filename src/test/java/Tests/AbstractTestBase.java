package Tests;


import com.aventstack.extentreports.gherkin.model.Scenario;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.BrowserUtils;
import utilities.Driver;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTestBase {

    WebDriver driver;



    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        BrowserUtils.wait(1);
        driver.close();
    }

}