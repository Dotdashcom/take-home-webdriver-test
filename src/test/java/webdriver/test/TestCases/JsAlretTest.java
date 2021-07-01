package webdriver.test.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import webdriver.test.Pages.JsAlret;
import webdriver.test.Util.ConfigReader;
import webdriver.test.Util.DriverFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;

public class JsAlretTest {


    private WebDriver driver;
    private JsAlret jsAlret;

    @BeforeClass
    public void Setup() throws IOException {

        String driverType = ConfigReader.getConfigProperties("driver");

        driver = DriverFactory.getDriver(driverType);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        jsAlret = new JsAlret(driver);

    }

    @Test
    public void clickJsAlertButton() {


        jsAlret.clickJsAlertButton();

        jsAlret.acceptDialog();

        assertTrue(jsAlret.getResultText().contains("You successfuly clicked an alert"));
    }

    @Test
    public void clickJsConfirmButton() {


        jsAlret.clickJsConfirmButton();

        jsAlret.acceptDialog();

        assertTrue(jsAlret.getResultText().contains("You clicked: Ok"));


    }

    @Test
    public void cancelDialogTest() {


        jsAlret.clickJsConfirmButton();

        jsAlret.dismissDialog();

        assertTrue(jsAlret.getResultText().contains("You clicked: Cancel"));

    }

    @Test
    public void addTextInPromptDialog() {

        jsAlret.clickJsPromptButton();

        jsAlret.AddTextToPromptDialog("Prompt Dialog Text");

        jsAlret.acceptDialog();

        assertTrue(jsAlret.getResultText().contains("You entered: Prompt Dialog Text"));



    }

    @Test
    public void cancelPromptDialog() {

        jsAlret.clickJsPromptButton();

        jsAlret.AddTextToPromptDialog("Prompt Dialog Text");

        jsAlret.dismissDialog();

        assertTrue(jsAlret.getResultText().contains("You entered: null"));

    }

    @AfterClass
    public void TearDown() {

        driver.quit();

    }


}
