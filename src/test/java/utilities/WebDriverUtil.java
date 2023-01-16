package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverUtil {
  public static WebDriver getDriver(String browser) {
    if (browser.equalsIgnoreCase("chrome")) {
      WebDriverManager.chromedriver().setup();
      return new ChromeDriver();
    } else if (browser.equalsIgnoreCase("firefox")) {
      WebDriverManager.firefoxdriver().setup();
      return new FirefoxDriver();
    } else {
      System.out.println("Browser does not exist.");
      System.out.println("browser=" + browser);
      return null;
    }

  }
}
