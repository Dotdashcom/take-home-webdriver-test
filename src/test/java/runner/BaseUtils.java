package runner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public final class BaseUtils {

    private static final String ENV_CHROME_OPTIONS = "CHROME_OPTIONS";
    private static final String ENV_APP_OPTIONS = "APP_OPTIONS";
    static final String PREFIX_PROP = "default.";
    private static final String PROP_CHROME_OPTIONS = PREFIX_PROP + ENV_CHROME_OPTIONS.toLowerCase();
    private static final String BASE_URL = "http://localhost:7080/";
    private static Properties properties;

    private static void initProperties() {
        if (properties == null) {
            properties = new Properties();
            if (isServerRun()) {
                properties.setProperty(PROP_CHROME_OPTIONS, System.getenv(ENV_CHROME_OPTIONS));

                if (System.getenv(ENV_APP_OPTIONS) != null) {
                    for (String option : System.getenv(ENV_APP_OPTIONS).split(";")) {
                        String[] optionArr = option.split("=");
                        properties.setProperty(PREFIX_PROP + optionArr[0], optionArr[1]);
                    }
                }
            } else {
                try {
                    InputStream inputStream = BaseUtils.class.getClassLoader().getResourceAsStream("config.properties");
                    if (inputStream == null) {
                        System.out.println("ERROR: The \u001B[31mconfig.properties\u001B[0m file not found in src/test/resources/ directory.");
                        System.exit(1);
                    }
                    properties.load(inputStream);
                } catch (IOException ignore) {
                }
            }
        }
    }

    private static final ChromeOptions chromeOptions;

    static {
        initProperties();

        chromeOptions = new ChromeOptions();
        String options = properties.getProperty(PROP_CHROME_OPTIONS);
        if (options != null) {
            for (String argument : options.split(";")) {
                chromeOptions.addArguments(argument);
            }
        }

        WebDriverManager.chromedriver().setup();
    }

    static boolean isServerRun() {
        return System.getenv("CI_RUN") != null;
    }

    static WebDriver createDriver() {
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }

    public static String getBaseUrl() {

        return BASE_URL;
    }

    public static String getCorrectUsername(){
        initProperties();

        return properties.getProperty("correct.username");
    }

    public static void log(String str) {
        System.out.println(str);
    }

    public static void logf(String str, Object... arr) {
        System.out.printf(str, arr);
        System.out.println();
    }

    public static String getCorrectPassword(){
        initProperties();

        return properties.getProperty("correct.password");
    }

    public static String getRandomString() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public static void scrollToEnd(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void scrollToElement_PlaceInCenter(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    public static class ExpectedConditions {
        public static ExpectedCondition<WebElement> elementIsNotMoving(final By locator) {
            return new ExpectedCondition<>() {
                private Point location = null;

                @Override
                public WebElement apply(WebDriver driver) {
                    WebElement element;
                    try {
                        element = driver.findElement(locator);
                    } catch (NoSuchElementException e) {
                        return null;
                    }

                    if (element.isDisplayed()) {
                        Point location = element.getLocation();
                        if (location.equals(this.location)) {
                            return element;
                        }
                        this.location = location;
                    }

                    return null;
                }
            };
        }

        public static ExpectedCondition<WebElement> elementIsNotMoving(final WebElement element) {
            return new ExpectedCondition<>() {
                private Point location = null;

                @Override
                public WebElement apply(WebDriver driver) {
                    if (element.isDisplayed()) {
                        Point location = element.getLocation();
                        if (location.equals(this.location)) {
                            return element;
                        }
                        this.location = location;
                    }

                    return null;
                }
            };
        }

        public static ExpectedCondition<Boolean> fileIsDownloaded(final String defaultDownloadLocation, String fileName) {
            return new ExpectedCondition<>() {
                private final File defaultDownloadFolder = new File(defaultDownloadLocation);
                String[] listFiles = new String[]{};
                @Override
                public Boolean apply(WebDriver driver) {
                    try {
                        listFiles = defaultDownloadFolder.list();
                    } catch (NullPointerException e) {

                    }

                    return Arrays.stream(listFiles).anyMatch(element -> element.equals(fileName));
                }
            };
        }
    }
}