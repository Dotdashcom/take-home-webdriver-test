package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class Base {

    public static WebDriver driver;
    public static WebDriverWait explicitWait;
    public static Wait<WebDriver> fluentWait;
    public static ExtentReports extent = new ExtentReports();

    public void initDriver(String browser) {
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
        extent.createTest("test result");
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
    }

    @BeforeMethod
    @Parameters({"browser", "URL"})
    public void setDriver(@Optional("chrome") String browser, @Optional("http://localhost:7080/download") String URL) {
        initDriver(browser);
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        explicitWait = new WebDriverWait(driver, 20);
        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    //helper methods
    public void waitForVisibilityOfElement(WebElement element) {
        explicitWait.until(ExpectedConditions.visibilityOf(element));

    }

    public void clickOnElement(WebElement element) {
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

}
