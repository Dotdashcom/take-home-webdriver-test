package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class Iframe extends Base{
    private WebDriver driver;
    private String baseUrl = "http://localhost:7080/iframe";
    private WebElement iFrame;
    private WebElement textField;
    private WebElement closeButton;


    @BeforeMethod
    public void setUp() throws IOException {
        driver = initializeDriver();
        driver.get(baseUrl);
        closeButton = driver.findElement(By.xpath("//div[@class='tox-icon']"));
    }


    @Test
    public void iFrame() throws InterruptedException {

        closeButton.click();

        iFrame = driver.findElement(By.className("tox-edit-area__iframe"));
        driver.switchTo().frame(iFrame);

        textField = driver.findElement(By.id("tinymce"));
        textField.clear();
        textField.sendKeys("Hello there");
        String confirmText = textField.getText();

        Assert.assertEquals(confirmText,"Hello there");

    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
