
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
    WebDriver webDriver;
    String baseUrl = "http://localhost:7080";
    
    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get(baseUrl);
    }

    @AfterTest
    public void tearDown(){
        webDriver.quit();
    }
}
