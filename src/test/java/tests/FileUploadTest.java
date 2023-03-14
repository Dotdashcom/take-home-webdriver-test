package tests;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class FileUploadTest {

    private static WebDriver driver;
    private static String URL = "";

    @Before
    public void beforeStart() {
        EnvironmentManager.initWebDriver();
        driver = RunEnvironment.getWebDriver();
        URL = RunEnvironment.getUrlBase();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void fileUpload() {

        String resultTextExpected = "File Uploaded!";
        String textGotten = "";

        driver.get(URL + "/upload");

        try {
            WebElement uploadFile = driver.findElement(By.id("file-upload"));

            uploadFile.sendKeys("C:\\Users\\Bryan Rodriguez\\Pictures\\vancouver_BC.jpg");

            driver.findElement(By.id("file-submit")).click();

            textGotten = driver.findElement(By.cssSelector("div.example>h3")).getText();

        } catch (Exception e) {
            System.out.println("Something was wrong : " + e.getMessage());
        }

        assertEquals(resultTextExpected, textGotten);

    }

    @After
    public void tearDown() {
        EnvironmentManager.shutDownDriver();
    }
}
