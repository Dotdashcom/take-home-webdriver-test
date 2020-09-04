package pagesExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClase {

    public static WebDriver driver;

    private static String BaseUrl = "http://localhost:7080";

    public static void setUp(String endPoint) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BaseUrl + "/" + endPoint);


    }

    public static void tearDown() {
        driver.quit();
    }

}

