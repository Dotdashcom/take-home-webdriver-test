package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utilities.WebDriverUtil;

import java.time.Duration;

public class TestBase {

  protected WebDriver driver;

  @BeforeMethod
  public void setUp() {
    driver = WebDriverUtil.getDriver("chrome");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }


}
