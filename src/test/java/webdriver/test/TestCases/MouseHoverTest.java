package webdriver.test.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import webdriver.test.Pages.MouseHover;
import webdriver.test.Util.ConfigReader;
import webdriver.test.Util.DriverFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class MouseHoverTest {


    private WebDriver driver;
    private MouseHover mouseHover;

    @BeforeClass
    public void Setup() throws IOException {

        String driverType = ConfigReader.getConfigProperties("driver");

        driver = DriverFactory.getDriver(driverType);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        mouseHover = new MouseHover(driver);

    }

    @Test
    public void MouseHoverTextValidation()  {



        mouseHover.hoverOverImage(0);

        String user1Caption = mouseHover.getVisibleContent(0);

        assertTrue(user1Caption.contains("name: user1") && user1Caption.contains("View profile"));


        mouseHover.hoverOverImage(1);

        String user2Caption = mouseHover.getVisibleContent(1);

        assertTrue(user2Caption.contains("name: user2") && user1Caption.contains("View profile"));


        mouseHover.hoverOverImage(2);

        String user3Caption = mouseHover.getVisibleContent(2);

        assertTrue(user3Caption.contains("name: user3") && user1Caption.contains("View profile"));

    }


    @AfterClass
    public void TearDown() {

        driver.quit();

    }


}
