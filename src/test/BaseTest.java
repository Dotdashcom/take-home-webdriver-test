package src.test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import src.main.utilities.Browser;
import src.main.utilities.CommonMethods;

public class BaseTest {

    public String baseURL;
    public String browser;

    @BeforeClass
    public void beforeClass() {
        CommonMethods.readAllProperties();
        baseURL = CommonMethods.getBrowserProperty("base.url");
        browser = CommonMethods.getBrowserProperty("browser");
    }

    @BeforeMethod
    public void openBrowser() {
        Browser.instantiateDriver(browser);
    }

    @AfterMethod
    public void tearDownBrowser() {
        Browser.quitBrowser();
    }
}
