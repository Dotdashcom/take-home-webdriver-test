package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestFloatingMenu {
  WebDriver driver;

  @BeforeSuite
  public void initialize() {
    System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
    driver = new ChromeDriver();
  }

  @Test
  public void testFloatingMenu() throws InterruptedException {
    String url = "http://localhost:7080/floating_menu";
    driver.get(url);
    WebElement floatingMenu = driver.findElement(By.xpath("//*[@id='content']/div/h3"));
    Thread.sleep(1000);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    Thread.sleep(1000);
    assertTrue(floatingMenu.isDisplayed());

  }

  @AfterMethod
  public void  tearDown() {
    driver.close();
  }
}
