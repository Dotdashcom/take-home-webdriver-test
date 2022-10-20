package src.main.utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


    public class Browser {

        private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

        public static void instantiateDriver(String targetBrowser) {

            if(targetBrowser.equalsIgnoreCase("CHROME")) {
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());

            } else {
                System.out.println("The browser, " + targetBrowser + ", is NOT supported.");
            }
            if(driver != null) {
                driver.get().manage().window().maximize();
            }
        }

        public static void quitBrowser() {
            driver.get().quit();
        }

        public static <T> T open(String pageFullURL, Class<T> pageClassProxy) {
            driver.get().get(pageFullURL);

            // Before creating a PageObject, Wait until page is loaded.
            WebDriverWait wdWait = new WebDriverWait(driver.get(), Duration.ofSeconds(10));
            wdWait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor)wd).executeScript("return document.readyState").equals("complete"));

            return PageFactory.initElements(driver.get(), pageClassProxy);
        }

        public static void refresh() {
            driver.get().navigate().refresh();
        }

        public static void scrollByPage() {
            JavascriptExecutor jse = (JavascriptExecutor) (driver.get());
            jse.executeScript("window.scrollBy(0,300)", "");
        }

        public static void switchToIframe(String id) {
            driver.get().switchTo().frame(id);
        }

        public static void switchToDefault() {
            driver.get().switchTo().defaultContent();
        }
    }

