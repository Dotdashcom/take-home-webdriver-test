package webdriver.test.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import webdriver.test.Pages.DynamicControl;
import webdriver.test.Util.ConfigReader;
import webdriver.test.Util.DriverFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class DynamicControlTest {


    private WebDriver driver;
    private DynamicControl dynamicControl;

    @BeforeClass
    public void Setup() throws IOException {

        String driverType = ConfigReader.getConfigProperties("driver");

        driver = DriverFactory.getDriver(driverType);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        dynamicControl = new DynamicControl(driver);

    }

    @Test
    public void ClickDynamicControlButton() throws NullPointerException {

        // clicks on the Remove Button
        dynamicControl.clickRemoveButton();

        WebDriverWait wait = new WebDriverWait(driver, 5);
         //checkbox is gone
        assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox"))));
         //  Add Button  Add Button
        dynamicControl.clickAddButton();

         // checkbox is present
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));

        assertTrue(element.isDisplayed());


        dynamicControl.clickEnableButton(); // clicks on the Enable Button


        //text box is enabled.
        assertTrue(wait.until(ExpectedConditions.elementSelectionStateToBe(dynamicControl.inputField, dynamicControl.inputField.isEnabled())));

        //clicks on the Disable Button
        dynamicControl.clickDisableButton();


        // text box is disabled.
        assertTrue(wait.until(ExpectedConditions.attributeContains(dynamicControl.inputField, "disabled", "")));

    }


    @AfterClass
    public void TearDown() {

        driver.quit();

    }


}
