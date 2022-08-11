package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class TestDynamicLoading {

  WebDriver driver;

  @BeforeMethod
  public void initialize() {
    System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
    driver = new ChromeDriver();
  }

  @Test
  public void testDynamicLoading() {
    String url = "http://localhost:7080/dynamic_loading/2";
    driver.get(url);

    // click on the Start button
    WebElement startButton = driver.findElement(By.xpath("//*[@id=\'start\']/button"));
    startButton.click();

    // explicit wait
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    //assert Hello World!
    wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\'finish\']/h4"),"Hello World!"));
    assertTrue(true);

  }

  @AfterMethod
  public void  tearDown() {
    driver.close();
  }
}
