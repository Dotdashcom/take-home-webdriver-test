package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class JavaScriptAlerts extends Base{

    private WebDriver driver;
    private String baseUrl = "http://localhost:7080/javascript_alerts";
    private WebElement alertButton;
    private WebElement confirmButton;
    private WebElement promptButton;


    @BeforeMethod
    public void setUp() throws IOException {
        driver = initializeDriver();
        driver.get(baseUrl);
        alertButton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        confirmButton = driver.findElement((By.xpath("//button[@onclick='jsConfirm()']")));
        promptButton = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
    }


    @Test
    public void jsAlertButton() throws InterruptedException {

        alertButton.click();
       String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText,"I am a JS Alert");
        driver.switchTo().alert().accept();
    }

    @Test
    public void jsConfirmButton(){

        confirmButton.click();
        String confirmText = driver.switchTo().alert().getText();

        Assert.assertEquals(confirmText,"I am a JS Confirm");
        driver.switchTo().alert().accept();
    }

    @Test
    public void jsPromptButton(){

        promptButton.click();
        driver.switchTo().alert().sendKeys("Hello");
        driver.switchTo().alert().accept();

        String result = driver.findElement(By.id("result")).getText();
        result = result.substring(result.indexOf(":")+1).trim();

        Assert.assertEquals(result,"Hello");



    }




    @AfterMethod
    public void tearDown() {
        driver.quit();
    }





}
