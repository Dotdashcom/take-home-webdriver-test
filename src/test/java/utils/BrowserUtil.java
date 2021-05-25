package utils;
import common.DDCommon;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserUtil {
    public final static String BaseUrl = "http://localhost:7080/";
    //final static String CHROME_DRIVER_LOCATION = "";
    protected static DDCommon DDCommon;
    private static WebDriver driver;
    public static DDCommon initBrowser() {
        DDCommon = new DDCommon();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return DDCommon;
    }

    public static WebDriver GetDriver(){
        return driver;
    }
}
