package webdriver.test.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import webdriver.test.Pages.Iframe;
import webdriver.test.Util.ConfigReader;
import webdriver.test.Util.DriverFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;


public class IframeTextTest {


    private WebDriver driver;
    private Iframe iframe;

    @BeforeClass
    public void Setup() throws IOException {

        String driverType = ConfigReader.getConfigProperties("driver");

        driver = DriverFactory.getDriver(driverType);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        iframe = new Iframe(driver);

    }

    @Test
    public void IframeTextValidation(){


        iframe.closeIcon();

        iframe.editTextInIframe("This is WebDriver Test");

        driver.switchTo().frame(iframe.iFrameEditorSection);

        assertTrue(iframe.iFrameBodyEditor.getText().contains("This is WebDriver Test"));

    }


    @AfterClass
    public void TearDown() {

        driver.quit();

    }


}
