package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtil {

  private DriverUtil() {

  }

  private static WebDriver driver;

  public static WebDriver getDriver() {
    if (driver == null) {
      String browser = PropertiesReadingUtil.getProperties("browser");
      switch (browser) {
        case "chrome":
          WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();
          break;
        case "firefox":
          WebDriverManager.firefoxdriver().setup();
          driver = new FirefoxDriver();
          break;

      }
    }
    return driver;

  }

  public static void closeDriver() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }


}
