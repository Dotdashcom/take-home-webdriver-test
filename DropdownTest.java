package testPackages;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class DropdownTest extends BaseTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/dropdown");
    }

    @Test
    public void testDropdown() {
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        dropdown.click();

        WebElement option1 = driver.findElement(By.xpath("//option[@value='1']"));
        option1.click();
        Assert.assertTrue(option1.isSelected());

        WebElement option2 = driver.findElement(By.xpath("//option[@value='2']"));
        option2.click();
        Assert.assertTrue(option2.isSelected());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
