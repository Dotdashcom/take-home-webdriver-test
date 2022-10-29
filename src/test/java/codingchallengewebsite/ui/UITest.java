package codingchallengewebsite.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import org.openqa.selenium.remote.LocalFileDetector;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class UITest {
    public static final String DEFAULT_BROWSER = "chrome";
    public static final String DEFAULT_BROWSER_VERSION = "106.0.5249.119";
    public static final String DEFAULT_BROWSER_HEADLESS = "false";
    public static final String downloadsFolder = Paths.get("target/").toAbsolutePath().toString();
    private RemoteWebDriver driver;
    private String baseUrl;
    private static final String pageFooterXpath = "//*[@id='page-footer']";

    public UITest() { BasicConfigurator.configure(); Logger.getRootLogger().setLevel(Level.INFO);}

    @Parameters({"browser", "browserVersion", "codingChallengeWebsite.headlessBrowser", "codingChallengeWebsite.baseUrl", "codingChallengeWebsite.baseUrlSG", "codingChallengeWebsite.seleniumGridUrl", "codingChallengeWebsite.useSeleniumGrid"})
    @BeforeMethod
        public void setUp(@Optional(DEFAULT_BROWSER) String browser, @Optional(DEFAULT_BROWSER_VERSION) String browser_version, @Optional(DEFAULT_BROWSER_HEADLESS) String headless, @Optional("") String base_url, @Optional("") String base_urlSG, @Optional("") String remote_url, @Optional("") String useSeleniumGrid) {
        if (useSeleniumGrid.equals("true")) { this.setBaseUrl(base_urlSG); } else { this.setBaseUrl(base_url); }

        switch (browser) {
            case "chrome":
                this.setDriver(requestChromeDriver(browser_version, headless, remote_url, useSeleniumGrid));
                break;
            case "firefox":
                // Firefox To be implemented
                break;
            case "edge":
                // Edge To be implemented
                break;
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    private RemoteWebDriver requestChromeDriver(String browserVersion, String headless, String remoteUrl, String useSeleniumGrid) {
        ChromeOptions chromeOptions = new ChromeOptions();
        Map<String, Object> chromeExpOptions = new HashMap<>();

        // Local session - Set experimental options
        if (!useSeleniumGrid.equals("true")) {
            chromeExpOptions.put("download.default_directory", downloadsFolder);
        }
        chromeExpOptions.put("download.prompt_for_download", false);
        chromeExpOptions.put("profile.default_content_settings.popups", 0); //

        chromeOptions.setExperimentalOption("prefs", chromeExpOptions);

        // Common + hacky options
        chromeOptions.addArguments("download.prompt_for_download", "false");
        chromeOptions.addArguments("safebrowsing.enabled", "false");
        chromeOptions.addArguments("--ignore-certificate-errors", "--disable-gpu");
        chromeOptions.addArguments("--disable-web-security");
        chromeOptions.addArguments("--allow-running-insecure-content");
        chromeOptions.addArguments("--ignore_ssl");
        chromeOptions.addArguments("--start-maximized"); //
        chromeOptions.addArguments("--disable-infobars"); //
        chromeOptions.addArguments("--test-type"); //
        chromeOptions.addArguments("--disable-extensions"); //

        if (headless.equals("true")) {
            chromeOptions.addArguments("--headless", "--window-size=1920,1200", "--no-sandbox"); }

        // Remote driver session
        if (useSeleniumGrid.equals("true")) {
            //WebDriverManager.chromedriver().browserInDocker().browserVersion("106.0.5249.119");
            WebDriverManager.chromedriver().driverVersion("106.0.5249.61").setup();
            WebDriverManager.chromedriver().useBetaVersions();
            WebDriverManager.chromedriver().forceDownload();
            WebDriverManager.chromedriver().browserVersionDetectionCommand(" ");
            try {
                this.driver = (RemoteWebDriver) WebDriverManager.chromedriver().remoteAddress(new URL(remoteUrl)).capabilities(chromeOptions).create();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            this.driver.setFileDetector(new LocalFileDetector());
            return driver;
        } else {
            chromedriver().browserVersion(browserVersion).setup();
            return new ChromeDriver(chromeOptions);
        }
    }

    public void dragAndDropJS(WebElement source, WebElement destination)
    {
        JavascriptExecutor js = (JavascriptExecutor) this.getDriver();
        js.executeScript("""
                function createEvent(typeOfEvent) {
                var event = document.createEvent('CustomEvent');
                event.initCustomEvent(typeOfEvent,true, true, null);
                event.dataTransfer = {
                data: {},
                setData: function (key, value) {
                this.data[key] = value;
                },
                getData: function (key) {
                return this.data[key];
                }
                };
                return event;
                }

                function dispatchEvent(element, event,transferData) {
                if (transferData !== undefined) {
                event.dataTransfer = transferData;
                }
                if (element.dispatchEvent) {
                element.dispatchEvent(event);
                } else if (element.fireEvent) {
                element.fireEvent("on" + event.type, event);
                }
                }

                function simulateHTML5DragAndDrop(element, destination) {
                var dragStartEvent =createEvent('dragstart');
                dispatchEvent(element, dragStartEvent);
                var dropEvent = createEvent('drop');
                dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);
                var dragEndEvent = createEvent('dragend');
                dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);
                }

                var source = arguments[0];
                var destination = arguments[1];
                simulateHTML5DragAndDrop(source,destination);""",source, destination);
    }
    public static void reloadPage(RemoteWebDriver driver) { driver.navigate().refresh(); }

    public static String cleanTextContent(String text)
    {
        // strips off all non-ASCII characters
        text = text.replaceAll("[^\\x00-\\x7F]", "");
        // erases all the ASCII control characters
        text = text.replaceAll("[\\p{Cntrl}&&[^\r\n\t]]", "");
        // removes non-printable characters from Unicode
        text = text.replaceAll("\\p{C}", "");
        return text.trim();
    }

    public RemoteWebDriver getDriver() {
        return this.driver;
    }

    public void setDriver(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public final Boolean isPageOpen(String pageUrl, WebElement pageTitle) { return this.getDriver().getCurrentUrl().equals(pageUrl) && pageTitle.isDisplayed(); }
    public final Boolean isPageOpen(String pageUrl) { return this.getDriver().getCurrentUrl().equals(pageUrl); }

    public final WebElement getPageFooter() { return this.getDriver().findElement(By.xpath(pageFooterXpath)); }

    public final void pageFactoryInitWait(WebElement pageTitle) {
        WebDriverWait pageFactoryInitWait = new WebDriverWait(this.getDriver(), Duration.ofSeconds(10), Duration.ofSeconds(5));
        pageFactoryInitWait.until(ExpectedConditions.and(visibilityOf(pageTitle), visibilityOf(this.getPageFooter())));
    }
}