package webdriver.test.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import webdriver.test.Pages.FloatingMenu;
import webdriver.test.Util.ConfigReader;
import webdriver.test.Util.DriverFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;

public class FloatingMenuTest {


    private WebDriver driver;
    private FloatingMenu floatingMenu;

    @BeforeClass
    public void Setup() throws IOException {

        String driverType = ConfigReader.getConfigProperties("driver");

        driver = DriverFactory.getDriver(driverType);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        floatingMenu = new FloatingMenu(driver);

    }

    @Test
    public void FloatingMenuValidation() throws InterruptedException {



        floatingMenu.scrollToPage();

        assertTrue(driver.getPageSource().contains("Home")); // validate in page source

        assertTrue(floatingMenu.floatingMenuDiv.isDisplayed()); // validate in UI main DIV

        assertTrue(floatingMenu.floatingMenuHomeLink.isDisplayed());// validate in UI home link


    }


    @AfterClass
    public void TearDown() {

        driver.quit();

    }


}
