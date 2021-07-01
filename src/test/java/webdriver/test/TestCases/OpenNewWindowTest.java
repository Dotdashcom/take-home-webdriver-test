package webdriver.test.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import webdriver.test.Pages.OpenNewWindow;
import webdriver.test.Util.ConfigReader;
import webdriver.test.Util.DriverFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;

public class OpenNewWindowTest {


    private WebDriver driver;
    private OpenNewWindow openNewWindow;

    @BeforeClass
    public void Setup() throws IOException {

        String driverType = ConfigReader.getConfigProperties("driver");

        driver = DriverFactory.getDriver(driverType);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        openNewWindow = new OpenNewWindow(driver);

    }

    @Test
    public void openInNewTab() {

        openNewWindow.ClickNewWindowLink();

        assertTrue( openNewWindow.getNewWindowText().contains("New Window"));
    }

    @AfterClass
    public void TearDown() {

        driver.quit();

    }


}
