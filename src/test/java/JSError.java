import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSError {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:7080/javascript_error");
        driver.manage().window().maximize();
    }
    @Test
    public void jsErrorTest(){
        //Test finds the JavaScript error on the page
        WebElement error = driver.findElement(By.xpath("//p[contains(text(),'This page has a JavaScript error in the onload eve')]"));
        System.out.println(error.getText());
        String expectedError = "Cannot read property 'xyz' of undefined.";
        String actualError = error.getText();
        //Test asserts page has error
        Assert.assertEquals(actualError,expectedError, "error message does not match");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
