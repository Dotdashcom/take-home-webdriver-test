package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestFileUpload{
  WebDriver driver;

  @BeforeMethod
  public void Setup() {
    System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("http://localhost:7080");
  }

  @Test
  public void uploadFileTest () {

    String filePath="E:/File.txt";
    System.out.println("Upload file test");
    WebElement pageLink = driver.findElement(By.xpath("//a[contains(text(),'File Upload')]"));
    pageLink.click();
    WebElement uploadFileLink = driver.findElement(By.xpath("//*[@id=\"file-upload\"]"));
    uploadFileLink.sendKeys(filePath);

    WebElement uploadSubmit = driver.findElement(By.cssSelector("input[type='submit']"));
    uploadSubmit.click();
  }

  @AfterMethod
  public void teardown() {
    driver.quit();
  }
}
