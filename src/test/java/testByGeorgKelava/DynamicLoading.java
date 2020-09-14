package testByGeorgKelava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class DynamicLoading {

    public DynamicLoading() {
    }

    @BeforeMethod
    public void setUp() {
        Driver.get().get(ConfigurationReader.get("baseUrl") + "dynamic_loading/2");
        Driver.get().manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }


    @Test
    public void dynamicLoadingTest() {
        WebElement startButton = Driver.get().findElement(By.xpath("//button[contains(text(), 'Start')]"));
        startButton.click();
        WebElement helloWorldText = Driver.get().findElement(By.xpath("//h4[contains(text(), 'Hello World!')]"));
        WebDriverWait wait = new WebDriverWait(Driver.get(), 15);
        wait.until(ExpectedConditions.visibilityOf(helloWorldText));
        String expectedText = "Hello World!";
        String actualText = helloWorldText.getText();
        Assert.assertTrue(actualText.contains(expectedText));
    }
}
