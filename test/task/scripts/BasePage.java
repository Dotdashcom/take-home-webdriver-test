package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class BasePage {
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
