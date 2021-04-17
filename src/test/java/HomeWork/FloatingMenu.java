package HomeWork;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class FloatingMenu extends Base{
    private WebDriver driver;
    private String baseUrl = "http://localhost:7080/floating_menu";

    @BeforeMethod
    public void setUp() throws IOException {
        driver = initializeDriver();
        driver.get(baseUrl);

    }

    @Test
    public void floatingMenu() {

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("window.scrollBy(0,500)");

        WebElement menu = driver.findElement(By.id("menu"));
        Assert.assertTrue(menu.isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }




}
