package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestFileDownload {
  WebDriver driver;

  @BeforeMethod
  public void Setup() {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anoj\\IdeaProjects\\DotDashAnojSelenProject\\drivers\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("http://localhost:7080");
  }

  @Test
  public void downloadfile () {
    driver.get("http://localhost:7080/download/some-file.txt");
    System.out.println("Congrats your file is downloaded");
  }

  @AfterMethod
  public void teardown() {
    driver.quit();
  }
}
