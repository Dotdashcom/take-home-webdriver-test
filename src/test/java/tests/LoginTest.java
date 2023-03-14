package tests;

import environment.EnvironmentManager;
import environment.RunEnvironment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class LoginTest {
    private static WebDriver driver;
    private static String URL = "";

    @Before
    public void beforeStart() {
        EnvironmentManager.initWebDriver();
        driver = RunEnvironment.getWebDriver();
        URL = RunEnvironment.getUrlBase();
    }


    @Test
    public void validLoginCredentials() {

        String expectedResult = "Welcome to the Secure Area. When you are done click logout below.";
        String gottenResult;

        System.out.println(URL);

        driver.get(URL+"/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.id("password")).submit();

       try{
           Thread.sleep(120);
           gottenResult = driver.findElement(By.className("subheader")).getText();
       }
       catch (Exception e){
           System.out.println("Something was wrong : "+e.getMessage());
           gottenResult = "";
       }

        assertEquals(gottenResult, expectedResult);

    }

    @Test
    public void invalidLoginCredentials() {

        WebElement gottenResult;

        driver.get(URL+"/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith123");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.id("password")).submit();

        try{
            Thread.sleep(120);
            gottenResult = driver.findElement(By.id("password"));
        }
        catch (Exception e){
            System.out.println("Something was wrong : "+e.getMessage());
            gottenResult = null;
        }

        assertNotNull(gottenResult);
    }

    @After
    public void tearDown() {
        EnvironmentManager.shutDownDriver();
    }

}
