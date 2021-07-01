package webdriver.test.TestCases;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import webdriver.test.Pages.ContextMenu;
import webdriver.test.Util.ConfigReader;
import webdriver.test.Util.DriverFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;


public class ContextMenuTest {

    private WebDriver driver;
    private ContextMenu contextMenu;

    @BeforeClass
    public void Setup() throws IOException {

        String driverType = ConfigReader.getConfigProperties("driver");

        driver = DriverFactory.getDriver(driverType);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        contextMenu = new ContextMenu(driver);

    }

    @Test
    public void ContextMenuAlert() {

        contextMenu.rightClickContextMenu();

        assertTrue(contextMenu.getAlertMenuText().contains("You selected a context menu"));

        contextMenu.acceptAlertMenu();

    }



    @AfterClass
    public void TearDown(){

        driver.quit();

    }



}
