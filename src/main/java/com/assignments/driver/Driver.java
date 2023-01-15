package com.assignments.driver;

import com.assignments.exceptions.InvalidBrowserNameException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.assignments.driver.DriverManager.getDriver;
import static com.assignments.driver.DriverManager.setDriver;
import static com.assignments.enums.ConfigProperties.URL;
import static com.assignments.factory.LoggerFactory.info;
import static com.assignments.utils.PropertyUtils.getValue;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Driver class is responsible for invoking and closing the browser. It is also responsible for
 * setting the driver variable to DriverManager.
 */

public final class Driver {

  /**
   * Private constructor for avoiding external instantiation.
   */
  private Driver() {
  }

  /**
   * Get the browser value and initialise the browser based on that and throw {@link
   * com.assignments.exceptions.InvalidBrowserNameException} in case of invalid browser name.
   *
   * @param browser Value will be passed from com.assignments.tests.BaseTest
   */
  public static void initializeDriver(String browser) {
    if (isNull(getDriver())) {
      if (browser.equalsIgnoreCase("chrome")) {
        WebDriverManager.chromedriver().setup();
        setDriver(new ChromeDriver());
      } else if (browser.equalsIgnoreCase("firefox")) {
        WebDriverManager.firefoxdriver().setup();
        setDriver(new FirefoxDriver());
      } else if (browser.equalsIgnoreCase("edge")) {
        WebDriverManager.edgedriver().setup();
        setDriver(new EdgeDriver());
      } else {
        throw new InvalidBrowserNameException(
            "Invalid Browser Name. Please check config.properties");

      }
      getDriver().get(getValue(URL));
      getDriver().manage().window().maximize();
    }
  }

  /**
   * Terminates the browser instance.
   */
  public static void quitDriver() {
    if (nonNull(getDriver())) {
      getDriver().quit();
      info("Terminating browser instance");
      setDriver(null);
    }
  }

}
