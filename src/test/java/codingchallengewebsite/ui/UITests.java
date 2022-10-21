package codingchallengewebsite.ui;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

public class UITests {
    public static final String DEFAULT_BROWSER = "chrome";
    public static final String DEFAULT_BROWSER_VERSION = "106.0.5249.61";
    public static final String DEFAULT_BROWSER_HEADLESS = "false";
    public static final String DEFAULT_BASE_URL = "http://localhost:7080";
    public static final String REMOTE_SELENIUM_GRID = "";
    // public static final String REMOTE_SELENIUM_GRID = "http://localhost:4445/wd/hub";
    public static String downloadsFolder;
    public WebDriver driver;
    public String baseUrl;


    public UITests() {
        downloadsFolder = Paths.get("target").toAbsolutePath().toString();
    }

    @Parameters({"browser", "browser_version", "headless", "base_url", "remote"})
    @BeforeTest
        public void setUp(@Optional(DEFAULT_BROWSER) String browser, @Optional(DEFAULT_BROWSER_VERSION) String browser_version, @Optional(DEFAULT_BROWSER_HEADLESS) String headless, @Optional(DEFAULT_BASE_URL) String base_url, @Optional(REMOTE_SELENIUM_GRID) String remote) throws MalformedURLException {
            switch (browser) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    Map<String, Object> prefs = new HashMap<>();
                    prefs.put("download.default_directory", downloadsFolder);
                    prefs.put("download.prompt_for_download", false);
                    chromeOptions.setExperimentalOption("prefs", prefs);
                    chromeOptions.addArguments("--ignore-certificate-errors", "--disable-gpu");
                    if (headless.equals("true")) {
                        chromeOptions.addArguments("--headless", "--window-size=1920,1200", "--no-sandbox");
                    }
                    chromeOptions.addArguments("download.prompt_for_download", "false");
                    chromeOptions.addArguments("safebrowsing.enabled", "false");

                    if (!remote.isEmpty()) {
                        this.driver = new RemoteWebDriver(new URL(remote), chromeOptions);
                    } else {
                        chromedriver().browserVersion(DEFAULT_BROWSER_VERSION).setup();
                        this.driver = new ChromeDriver(chromeOptions);
                    }

                    break;
                case "firefox":
                    // Firefox To be implemented
                    break;
                case "edge":
                    // Edge To be implemented
                    break;
            }
            this.baseUrl = base_url;
    }

    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    public void dragAndDropJS(WebElement source, WebElement destination)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
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
    public void reloadPage(WebDriver driver) { driver.navigate().refresh(); }


    public static class CleanText
    {
        public static void main(String[] args)
        {

            File file = new File("c:/temp/data.txt");

            String uncleanContent = readFileIntoString(file);

            System.out.println(uncleanContent);

            String cleanContent = cleanTextContent(uncleanContent);

            System.out.println(cleanContent);
        }

        public static String readFileIntoString(File file)
        {
            StringBuilder contentBuilder = new StringBuilder();
            try (Stream<String> stream = Files.lines(Paths.get(file.toURI())))
            {
                stream.forEach(s -> contentBuilder.append(s).append("\n"));
            }
            catch (IOException e)
            {
                System.out.println("Error reading " + file.getAbsolutePath());
            }
            return contentBuilder.toString();
        }

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
    }
}
