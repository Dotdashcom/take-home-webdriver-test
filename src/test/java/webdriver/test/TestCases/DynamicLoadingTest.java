package webdriver.test.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import webdriver.test.Pages.DynamicLoading;
import webdriver.test.Util.ConfigReader;
import webdriver.test.Util.DriverFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class DynamicLoadingTest {


    private WebDriver driver;
    private DynamicLoading dynamicLoading;

    @BeforeClass
    public void Setup() throws IOException {

        String driverType = ConfigReader.getConfigProperties("driver");

        driver = DriverFactory.getDriver(driverType);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        dynamicLoading = new DynamicLoading(driver);

    }

    @Test
    public void dynamicLoadingMessage() throws NullPointerException{

        dynamicLoading.clickStartButton();


        assertTrue(dynamicLoading.getRenderMessage().contains("Hello World!"));

    }







    @AfterClass
    public void TearDown(){

        driver.quit();

    }



}
