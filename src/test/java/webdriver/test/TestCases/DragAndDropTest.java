package webdriver.test.TestCases;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import webdriver.test.Pages.DragAndDrop;
import webdriver.test.Util.ConfigReader;
import webdriver.test.Util.DriverFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class DragAndDropTest {

    private WebDriver driver;
    private DragAndDrop dragAndDrop;

    @BeforeClass
    public void Setup() throws IOException {

        String driverType = ConfigReader.getConfigProperties("driver");

        driver = DriverFactory.getDriver(driverType);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        dragAndDrop = new DragAndDrop(driver);

    }

    @Test
    public void dragAndDropColumn(){


        dragAndDrop.JavascriptExecutorForDragAndDrop(); // JavascriptExecutor for Drag and drop

        assertTrue(dragAndDrop.getHeader1Text().contains("B"));

        assertTrue(dragAndDrop.getHeader2Text().contains("A"));

        driver.close();
    }


    @AfterClass
    public void TearDown(){

        driver.quit();

    }



}
