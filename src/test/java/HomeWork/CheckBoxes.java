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

public class CheckBoxes extends Base{

    private WebDriver driver;
    private String baseUrl = "http://localhost:7080/checkboxes";
    private WebElement uncheckedBox;
    private WebElement checkedBox;



    @BeforeMethod
    public void setUp() throws IOException {
        driver = initializeDriver();
        driver.get(baseUrl);
        uncheckedBox = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        checkedBox = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void checkAndUnchekBoxes() throws InterruptedException {

        uncheckedBox.click();

        String check1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).getAttribute("checked");
        Assert.assertSame(check1,"true");

        checkedBox.click();

        String check2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")).getAttribute("checked");
        Assert.assertFalse(false, check2);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }



}
