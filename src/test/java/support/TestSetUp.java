package support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

    public class TestSetUp {

        private static WebDriver driver;

        //private static WebDriverManager wdm = WebDriverManager.firefoxdriver().browserInDocker();
        private static WebDriverManager wdm = WebDriverManager.chromedriver().browserInDocker();

        public static WebDriver getDriver() {
            return driver;
        }


        public static void tearDown() {
            wdm.quit();
        }

        public static void profileSetUp() {
            driver = wdm.create();
        }

    }


