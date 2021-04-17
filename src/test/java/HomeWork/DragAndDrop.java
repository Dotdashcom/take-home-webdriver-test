package HomeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DragAndDrop extends Base{
    private WebDriver driver;
    private String baseUrl = "http://localhost:7080/drag_and_drop";
    Actions action;
    private WebElement columnA;
    private WebElement columnB;

    @BeforeMethod
    public void setUp() throws IOException {
        driver = initializeDriver();
        driver.get(baseUrl);
        action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);


    }

    @Test(enabled = false)
    public void dragAndDrop() {

        columnA = driver.findElement(By.id("column-a"));
        columnB = driver.findElement(By.id("column-b"));

        action.dragAndDrop(columnA,columnB).build().perform();


        String confirmation = driver.findElement(By.xpath("//div[@id='column-a']/header")).getText();

        Assert.assertEquals(confirmation,"B");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }



}
