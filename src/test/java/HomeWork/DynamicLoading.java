package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DynamicLoading extends Base{


    private WebDriver driver;
    private String baseUrl = "http://localhost:7080/dynamic_loading/2";
    private WebElement startButton;

    @BeforeMethod
    public void setUp() throws IOException {
        driver = initializeDriver();
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        startButton = driver.findElement(By.xpath("//div[@id='start']/button"));
    }

    @Test
    public void dynamicLoading(){

        startButton.click();
        WebElement helloWorld = driver.findElement(By.xpath("//*[text()='Hello World!']"));
        String helloWorldText = helloWorld.getText();

        Assert.assertEquals(helloWorldText,"Hello World!");


    }






    @AfterMethod
    public void tearDown() {
        driver.quit();
    }











}

