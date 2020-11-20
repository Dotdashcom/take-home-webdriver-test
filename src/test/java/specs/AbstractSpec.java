package specs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by PSUSHKOV on Nov, 2020
 **/

// Abstract class for all tests
public abstract class AbstractSpec {
    public static final long DEFAULT_TIMEOUT = 15L;
    private static final long DEFAULT_PAUSE = 2000;
    public WebDriver driver;

    @BeforeTest
    public void init() {
        ChromeOptions ChromeOptions = new ChromeOptions();

        ChromeOptions.addArguments("window-size=1920,1080", "--no-sandbox", "--incognito", "--disable-gpu", "--start-maximized");
        //hromeOptions.addArguments("--headless", "window-size=1920,1080", "--no-sandbox", "--incognito", "--disable-gpu", "--start-maximized");

        driver = new ChromeDriver(ChromeOptions);

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(DEFAULT_PAUSE, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod(ITestResult result, ITestResult iTestResult) {

        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                System.out.println(result.getMethod().getMethodName() + ": PASS");
                break;

            case ITestResult.FAILURE:
                System.out.println(result.getMethod().getMethodName() + ": FAIL");
                break;

            case ITestResult.SKIP:
                System.out.println(result.getMethod().getMethodName() + ": SKIP");
                break;

            default:
                throw new RuntimeException(result.getTestName() + "Invalid status");
        }

    }

    @AfterTest(alwaysRun = true)
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
