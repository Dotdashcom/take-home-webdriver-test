package testPackages;
import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControlsTest extends BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://localhost:7080/dynamic_controls");
    }

    @Test
    public void testRemoveCheckbox() {
        WebElement removeButton = driver.findElement(By.cssSelector("#checkbox-example button"));
        removeButton.click();
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        wait.until(ExpectedConditions.invisibilityOf(checkbox));
        Assert.assertFalse(checkbox.isDisplayed());
    }

    @Test
    public void testAddCheckbox() {
        WebElement addButton = driver.findElement(By.cssSelector("#checkbox-example button"));
        addButton.click();
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        wait.until(ExpectedConditions.visibilityOf(checkbox));
        Assert.assertTrue(checkbox.isDisplayed());
    }

    @Test
    public void testEnableTextbox() {
        WebElement enableButton = driver.findElement(By.cssSelector("#input-example button"));
        enableButton.click();
        WebElement textbox = driver.findElement(By.cssSelector("#input-example input[type='text']"));
        wait.until(ExpectedConditions.elementToBeClickable(textbox));
        Assert.assertTrue(textbox.isEnabled());
    }

    @Test
    public void testDisableTextbox() {
        WebElement disableButton = driver.findElement(By.cssSelector("#input-example button"));
        disableButton.click();
        WebElement textbox = driver.findElement(By.cssSelector("#input-example input[type='text']"));
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(textbox)));
        Assert.assertFalse(textbox.isEnabled());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
